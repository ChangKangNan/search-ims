package com.example.service;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.io.IoUtil;
import cn.hutool.core.util.BooleanUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.json.JSONUtil;
import com.example.fm.bean.SearchConfig;
import com.example.fm.bean.SearchConfigInfo;
import com.example.fm.bean.SearchTableColumn;
import com.example.fm.dao.SearchConfigInfoMapper;
import com.example.fm.dao.SearchConfigMapper;
import com.example.generator.SearchType;
import net.sourceforge.pinyin4j.PinyinHelper;
import net.sourceforge.pinyin4j.format.HanyuPinyinCaseType;
import net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat;
import net.sourceforge.pinyin4j.format.HanyuPinyinToneType;
import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import static com.example.generator.SearchConstants.*;

/**
 * @author ckn
 */
@Service
public class SplitServiceImpl implements ISplitService {
    /**
     * 基本组件定义
     */
    public static Map<String, SearchType> searchTypeConditions = new HashMap<String, SearchType>() {{
        put(INPUT, new SearchType(INPUT, "[{\"name\":\"包含\",\"value\":\"Like\"}]"));
        put(DATE, new SearchType(DATE, "[{\"name\":\"范围\",\"value\":\"Range\"},{\"name\":\"等于\",\"value\":\"Equal\"},{\"name\":\"大于\",\"value\":\"Greater\"},{\"name\":\"大于等于\",\"value\":\"GreaterOrEqual\"},{\"name\":\"小于\",\"value\":\"Less\"},{\"name\":\"小于等于\",\"value\":\"LessOrEqual\"}]"));
        put(DATE_YEAR, new SearchType(DATE_YEAR, "[{\"name\":\"等于\",\"value\":\"Equal\"}]"));
        put(MONTH, new SearchType(MONTH, "[{\"name\":\"范围\",\"value\":\"Range\"},{\"name\":\"等于\",\"value\":\"Equal\"},{\"name\":\"大于\",\"value\":\"Greater\"},{\"name\":\"大于等于\",\"value\":\"GreaterOrEqual\"},{\"name\":\"小于\",\"value\":\"Less\"},{\"name\":\"小于等于\",\"value\":\"LessOrEqual\"}]"));
        put(INVOICE_MONTH, new SearchType(INVOICE_MONTH, "[{\"name\":\"等于\",\"value\":\"Equal\"}]"));
        put(NUMBER, new SearchType(NUMBER, "[{\"name\":\"等于\",\"value\":\"Equal\"},{\"name\":\"大于\",\"value\":\"Greater\"},{\"name\":\"大于等于\",\"value\":\"GreaterOrEqual\"},{\"name\":\"小于\",\"value\":\"Less\"},{\"name\":\"小于等于\",\"value\":\"LessOrEqual\"},{\"name\":\"不等于\",\"value\":\"NotEqual\"}]"));
        put(VALUES, new SearchType(SELECT, "[{\"name\":\"等于\",\"value\":\"Equal\"},{\"name\":\"不等于\",\"value\":\"NotEqual\"}]"));
        put(VALUES_LIKE, new SearchType(SELECT, "[{\"name\":\"包含\",\"value\":\"Like\"},{\"name\":\"不包含\",\"value\":\"NotLike\"}]"));
        put(DICT, new SearchType(SELECT, "[{\"name\":\"等于\",\"value\":\"Equal\"},{\"name\":\"不等于\",\"value\":\"NotEqual\"}]"));
        put(URL, new SearchType(SELECT, "[{\"name\":\"等于\",\"value\":\"Equal\"},{\"name\":\"不等于\",\"value\":\"NotEqual\"}]"));
    }};

    /**
     * 拆分
     *
     * @param configChineseName sql目录下的文件名(XXXX.sql)
     * @throws IOException
     */
    @Override
    @Transactional
    public void split(String configChineseName) throws IOException {
        ResourcePatternResolver resourceResolver = new PathMatchingResourcePatternResolver();
        Resource[] resources = resourceResolver.getResources("sql/" + configChineseName);
        for (Resource resource : resources) {
            String sql = IoUtil.read(resource.getInputStream()).toString();
            Integer version = getVersion(sql);
            String pageTag = "";
            try {
                pageTag = getPinyin(Objects.requireNonNull(resource.getFilename()).substring(0, resource.getFilename().lastIndexOf(".")));
                if (StrUtil.endWith(pageTag, "_")) {
                    pageTag = pageTag.substring(0, pageTag.length() - 1);
                }
            } catch (Exception e) {
                System.out.println("对应的文件拼音翻译错误!");
            }
            SearchConfig searchConfig = SearchConfigMapper.lambdaQuery()
                    .pageTag().equal(pageTag)
                    .one();
            if (searchConfig != null) {
                Integer sourceVersion = getVersion(searchConfig.getSearchSql());
                if (Objects.equals(version, sourceVersion)) {
                    throw new RuntimeException("内容有更新,请调整版本号!");
                }
                if (version < sourceVersion) {
                    throw new RuntimeException("当前操作的查询方案版本过低,请更新后重新执行!");
                }
                if (version > (sourceVersion + 1)) {
                    throw new RuntimeException("当前操作的查询方案版本过高,请重新确认数据库的查询方案版本!");
                }
                //重新生成配置
                SearchConfigMapper.lambdaUpdate()
                        .id().equal(searchConfig.getId())
                        .value()
                        .set(SearchConfig::getSearchSql, sql)
                        .execute();
                splitSearchConfigInfo(sql, pageTag, searchConfig.getId());
            } else {
                String chineseName = Objects.requireNonNull(resource.getFilename()).substring(0, resource.getFilename().lastIndexOf("."));
                SearchConfig insert = new SearchConfig();
                insert.setSearchSql(sql);
                insert.setPageTag(pageTag);
                insert.setConfigName(chineseName);
                SearchConfigMapper.lambdaInsert().insert(insert);
                splitSearchConfigInfo(sql, pageTag, insert.getId());
            }
        }
    }

    /**
     * 拆分searchConfigInfo明细
     *
     * @param sql
     * @param pageTag
     * @param searchId
     */
    public void splitSearchConfigInfo(String sql, String pageTag, Long searchId) {
        List<String> remarks = getRemarks(sql);
        sql = sql.substring(0, sql.toLowerCase().indexOf("from"));
        sql = StrUtil.replaceIgnoreCase(sql, SELECT, "");
        sql = sql.replaceAll("#(.*?)(\\r?\n)", "#");
        sql = sql.replaceAll("(,(\\s+)#)", ",#");
        String[] columns = sql.split(",#");
        List<SearchTableColumn> columnList = new ArrayList<>();
        for (String column : columns) {
            if (StrUtil.isBlank(column)) {
                continue;
            }
            column = column.replaceAll("#", "");
            column = StrUtil.trimStart(column);
            boolean asFlag = (!StrUtil.contains(column, "case ")) && StrUtil.containsAny(column, " as ", " As ", " AS ");
            Object[] array = null;
            if (asFlag) {
                array = Arrays.stream(column.split("(?i) as ")).filter(StrUtil::isNotBlank).toArray();
            } else {
                if (!StrUtil.containsAny(column, " as ", " As ", " AS ")) {
                    array = new Object[1];
                    array[0] = column;
                } else {
                    array = new Object[2];
                    int indexOf = column.toLowerCase().lastIndexOf(" as ");
                    array[0] = column.substring(0, indexOf);
                    array[1] = column.substring(indexOf + 4);
                }
            }
            String otherName;
            SearchTableColumn searchTableColumn = new SearchTableColumn();
            searchTableColumn.setSearchTableColumnInfo(array[0].toString().trim());
            boolean isAlias = false;
            if (array.length > 1) {
                otherName = array[1].toString().trim();
                isAlias = true;
            } else {
                otherName = array[0].toString().trim();
            }
            if (isAlias) {
                searchTableColumn.setSearchTableColumn(otherName);
            } else {
                String[] split = otherName.split("\\.");
                if (split.length > 1) {
                    searchTableColumn.setSearchTableColumn(split[1].trim());
                } else {
                    searchTableColumn.setSearchTableColumn(otherName);
                }
            }
            columnList.add(searchTableColumn);
        }
        System.out.println("columnList:" + JSONUtil.toJsonStr(columnList));
        List<SearchConfigInfo> infos = new ArrayList<>();
        for (int i = 0; i < columnList.size(); i++) {
            SearchTableColumn column = columnList.get(i);
            String remark = remarks.get(i);
            String searchKey;
            String searchTableColumnInfo = column.getSearchTableColumnInfo().trim();
            String searchTableColumn = column.getSearchTableColumn().trim();
            if (!searchTableColumn.equals(searchTableColumnInfo)) {
                searchKey = searchTableColumnInfo + "/*alias " + searchTableColumn + "*/";
            } else {
                searchKey = searchTableColumn;
            }
            String[] split = remark.split(" ");
            String searchName = split[0].substring(1);
            SearchConfigInfo searchConfigInfo = new SearchConfigInfo();
            searchConfigInfo.setSearchConfigId(searchId);
            searchConfigInfo.setPageTag(pageTag);
            searchConfigInfo.setSearchName(searchName);
            searchConfigInfo.setSearchKey(searchKey);
            //按照预先定义规则匹配组件类型
            searchConfigInfo = fullData(searchConfigInfo, split, searchName);
            String searchValueSource = searchConfigInfo.getSearchValueSource();
            if (StrUtil.isBlank(searchValueSource)) {
                searchConfigInfo.setSearchValueSource("in");
            }
            if (StrUtil.isBlank(searchConfigInfo.getSearchType())) {
                searchConfigInfo.setSearchType(searchTypeConditions.get(INPUT).getSearchType());
                searchConfigInfo.setLimitSearchConditions(searchTypeConditions.get(INPUT).getLimitSearchConditions());
            }
            infos.add(searchConfigInfo);
        }
        List<SearchConfigInfo> searchConfigInfos = SearchConfigInfoMapper.lambdaQuery().pageTag().equal(pageTag).list();
        if (CollUtil.isNotEmpty(searchConfigInfos)) {
            final Map<String, SearchConfigInfo> collect = searchConfigInfos.stream().collect(Collectors.toMap(SearchConfigInfo::getSearchKey, data -> data));
            List<SearchConfigInfo> addList = infos.stream().filter(info -> {
                String searchKey = info.getSearchKey();
                SearchConfigInfo searchConfigInfo = collect.get(searchKey);
                return searchConfigInfo == null;
            }).collect(Collectors.toList());
            List<SearchConfigInfo> updateList = infos.stream().filter(info -> {
                String searchKey = info.getSearchKey();
                SearchConfigInfo searchConfigInfo = collect.get(searchKey);
                return searchConfigInfo != null
                        && !(
                        StrUtil.equals(searchConfigInfo.getSearchName(), info.getSearchName())
                                && StrUtil.equals(searchConfigInfo.getLimitSearchConditions(), info.getLimitSearchConditions())
                                && StrUtil.equals(searchConfigInfo.getLimitSearchValues(), (info.getLimitSearchValues()))
                                && StrUtil.equals(searchConfigInfo.getSearchValueSource(), (info.getSearchValueSource()))
                                && StrUtil.equals(searchConfigInfo.getSearchType(), (info.getSearchType()))
                                && BooleanUtil.isTrue(searchConfigInfo.getHidden()) == BooleanUtil.isTrue(info.getHidden())
                );
            }).collect(Collectors.toList());
            List<SearchConfigInfo> originalData = infos.stream().filter(info -> {
                String searchKey = info.getSearchKey();
                SearchConfigInfo searchConfigInfo = collect.get(searchKey);
                return searchConfigInfo != null
                        && StrUtil.equals(searchConfigInfo.getSearchName(), info.getSearchName())
                        && StrUtil.equals(searchConfigInfo.getLimitSearchConditions(), info.getLimitSearchConditions())
                        && StrUtil.equals(searchConfigInfo.getLimitSearchValues(), (info.getLimitSearchValues()))
                        && StrUtil.equals(searchConfigInfo.getSearchValueSource(), (info.getSearchValueSource()))
                        && StrUtil.equals(searchConfigInfo.getSearchType(), (info.getSearchType()))
                        && BooleanUtil.isTrue(searchConfigInfo.getHidden()) == BooleanUtil.isTrue(info.getHidden());
            }).collect(Collectors.toList());
            if (CollUtil.isNotEmpty(updateList)) {
                updateList.forEach(
                        t -> {
                            SearchConfigInfo configInfo = collect.get(t.getSearchKey());
                            t.setId(configInfo.getId());
                            SearchConfigInfoMapper.lambdaUpdate().id()
                                    .equal(configInfo.getId())
                                    .update(t);
                        }
                );
            }
            infos = addList;
            List<Long> sum = new ArrayList<>();
            if (CollUtil.isNotEmpty(originalData)) {
                List<Long> longs = originalData.stream().map(t -> collect.get(t.getSearchKey()).getId()).collect(Collectors.toList());
                CollUtil.addAllIfNotContains(sum, longs);
            }
            if (CollUtil.isNotEmpty(updateList)) {
                List<Long> longs = updateList.stream().map(t -> collect.get(t.getSearchKey()).getId()).collect(Collectors.toList());
                CollUtil.addAllIfNotContains(sum, longs);
            }
            if (CollUtil.isNotEmpty(sum)) {
                SearchConfigInfoMapper.lambdaDelete()
                        .id().notIn(sum.toArray())
                        .pageTag().equal(pageTag)
                        .closeDeletedProtect()
                        .delete();
            }
        }
        System.out.println("json:" + JSONUtil.toJsonStr(infos));
        if (CollUtil.isNotEmpty(infos)) {
            SearchConfigInfoMapper.lambdaInsert().insertBatch(infos);
        }
    }

    /**
     * 填充数据
     */
    public SearchConfigInfo fullData(SearchConfigInfo searchConfigInfo, String[] msg, String searchName) {
        for (int j = 1; j < msg.length; j++) {
            int check = 0;
            String mark = msg[j];
            if (StrUtil.equalsAny(mark, INPUT, DATE, DATE_YEAR, MONTH, INVOICE_MONTH, NUMBER, VALUES, VALUES_LIKE, DICT, URL)) {
                SearchType searchType = searchTypeConditions.get(mark);
                searchConfigInfo.setSearchType(searchType.getSearchType());
                searchConfigInfo.setLimitSearchConditions(searchType.getLimitSearchConditions());
                if (mark.equals(URL)) {
                    searchConfigInfo.setSearchValueSource(URL);
                }
                if (mark.equals(DICT)) {
                    searchConfigInfo.setSearchValueSource("dictionary");
                }
                check++;
            }
            if (mark.contains("=")) {
                String[] kv = mark.split("=");
                String key = kv[0];
                String val = kv[1];
                val = val.replaceAll("\\(BLACK\\)", " ");
                if (key.equals("limit")) {
                    key = VALUES;
                }
                if (key.equals("hidden")) {
                    searchConfigInfo.setHidden(Integer.parseInt(val) > 0 ? Boolean.TRUE : Boolean.FALSE);
                } else {
                    if (!StrUtil.equalsAny(searchConfigInfo.getSearchValueSource(), URL, "dictionary")) {
                        searchConfigInfo.setSearchValueSource(key);
                    }
                    searchConfigInfo.setLimitSearchValues(val);
                }
                check++;
            }
            if (j == 1 && check == 0) {
                searchConfigInfo.setSearchName(searchName + StrUtil.TAB + mark);
            }
        }
        return searchConfigInfo;
    }

    /**
     * 版本号获取
     *
     * @param originalSql
     * @return
     */
    public Integer getVersion(String originalSql) {
        Pattern p = Pattern.compile("#(.*)");
        Matcher m = p.matcher(originalSql);
        Integer version = null;
        while (m.find()) {
            if (m.group().contains("#自动生成的版本信息")) {
                String substring = m.group().trim().substring(10);
                version = Integer.parseInt(substring);
            }
        }
        return version;
    }

    /**
     * 转换拼音
     *
     * @param str
     * @return
     * @throws BadHanyuPinyinOutputFormatCombination
     */
    public String getPinyin(String str) throws BadHanyuPinyinOutputFormatCombination {
        HanyuPinyinOutputFormat format = new HanyuPinyinOutputFormat();
        String fieldName = str;
        format.setCaseType(HanyuPinyinCaseType.LOWERCASE);
        format.setToneType(HanyuPinyinToneType.WITHOUT_TONE);
        String formatStr = fieldName.replaceAll("([a-zA-Z0-9]+)", "$1_");
        String regEx = "([`!@#$%^&*()+=|{}':;',//[//].<>/?！@#￥%……&*（）——+|{}【】‘；：”“’。，、？-])";
        formatStr = formatStr.replaceAll(regEx, "_");
        String yuPinyinString = PinyinHelper.toHanYuPinyinString(formatStr + "_", format, "_", true);
        return yuPinyinString.substring(0, yuPinyinString.length() - 1);
    }

    /**
     * 备注信息
     *
     * @param sql
     * @return
     */
    public List<String> getRemarks(String sql) {
        List<String> stringList = new ArrayList<>();
        Pattern p = Pattern.compile("#(.*)");
        Matcher m = p.matcher(sql);
        while (m.find()) {
            if (!m.group().contains("自动生成的版本信息")) {
                stringList.add(m.group());
            }
        }
        return stringList;
    }
}
