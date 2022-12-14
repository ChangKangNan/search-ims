package com.example;

import cn.ft.ckn.fastmapper.component.DeleteDao;
import cn.ft.ckn.fastmapper.component.InsertDao;
import cn.ft.ckn.fastmapper.component.SplicingParam;
import cn.ft.ckn.fastmapper.component.UpdateDao;
import cn.ft.ckn.fastmapper.config.FastMapperConfig;
import cn.hutool.core.collection.ListUtil;
import com.alibaba.druid.pool.DruidDataSource;
import com.example.fm.bean.SearchConfig;
import com.example.fm.bean.SearchConfigInfo;
import com.example.fm.dao.SearchConfigMapper;
import com.example.service.ISplitService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.Date;
import java.util.List;

/**
 * @author ckn
 * @date 2022/12/13
 */
@SpringBootTest
public class Generator {
    @Resource
    ISplitService splitService;

    @Test
    void generate() throws IOException {
        FastMapperConfig.isOpenSQLPrint=true;
        FastMapperConfig.setDeleted(true,"deleted",false,true);
        FastMapperConfig.setTimeAuto(true,true);
        splitService.split("咨询服务费退款.sql");
    }

    @Test
    void test(){
        FastMapperConfig.isOpenSQLPrint=true;
        FastMapperConfig.setDeleted(true,"deleted",false,true);
        FastMapperConfig.setTimeColumn("create_time","updata_time");
        FastMapperConfig.setTimeAuto(true,true);
        //        List<SearchConfig> list = SearchConfigMapper.lambdaQuery()
//                .id().notIn(list1,55)
//                .list();
//        SearchConfig searchConfig=new SearchConfig();
//        searchConfig.setConfigName("咨询服务费退款1");
//        searchConfig.setPageTag("zi_xun_fu_wu_fei_tui_kuan");
//        searchConfig.setDeleted(false);
//        SearchConfigMapper.lambdaUpdate().id().equal(626L)
//                .updateOverride(searchConfig);
//        SearchConfig searchConfig=new SearchConfig();
//        searchConfig.setId(626L);
//        searchConfig.setConfigName("咨询服务费退款2");
        SearchConfigMapper.lambdaDelete().configName().equal("咨询服务费退款3").delete();
//        SearchConfig searchConfig = new SearchConfig();
//        searchConfig.setConfigName("咨询服务费退款3");
//        searchConfig.setPageTag("11212121");
//        searchConfig.setRemark("11");
//        SearchConfigMapper.lambdaInsert().insert(searchConfig);
//                .updateOverride(searchConfig);
    }

    @Test
    void testReflect(){
        FastMapperConfig.isOpenSQLPrint=true;
//        SearchConfig searchConfig = new SearchConfig();
//        searchConfig.setConfigName("abc");
//        searchConfig.setPageTag("test_abc");
//        searchConfig.setDeleted(false);
//        searchConfig.setCreateTime(new Date());
//        searchConfig.setUpdataTime(new Date());
//        new InsertDao<>(new SplicingParam(), SearchConfig.class, null).insert(searchConfig);
        SearchConfigInfo searchConfigInfo = new SearchConfigInfo();
        searchConfigInfo.setId(100390L);
        searchConfigInfo.setDeleted(true);
        new UpdateDao<>(new SplicingParam(),SearchConfigInfo.class,null).updateByPrimaryKey(searchConfigInfo);
//        SearchConfigInfo searchConfigInfo = new SearchConfigInfo();
//        searchConfigInfo.setId(100390L);
//        searchConfigInfo.setSearchName("可退金额1");
//        new DeleteDao<>(new SplicingParam(),SearchConfigInfo.class,null).delete();
    }
}
