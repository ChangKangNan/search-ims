package com.example.fm.action;
import cn.ft.ckn.fastmapper.component.*;
import com.example.fm.bean.SearchConfigInfo;

public class SearchConfigInfoAction {
public static class InsertMapper extends InsertDao<SearchConfigInfo, InsertMapper> {
        public InsertMapper(SplicingParam splicingParam){
        super(splicingParam,SearchConfigInfo.class, InsertMapper.class);
        }
}

public static class BaseSelectMapper extends BaseSelectAction<SearchConfigInfo, BaseSelectMapper> {
        public BaseSelectMapper(SplicingParam splicingParam) {
        super(splicingParam,SearchConfigInfo.class, BaseSelectMapper.class);
        }


        public SelectCriteria<SearchConfigInfo, BaseSelectMapper> id() {
        this.fieldName="id";
        return new SelectCriteria<>(this.splicingParam, this.fieldName,SearchConfigInfo.class, BaseSelectMapper.class);
        }


        public SelectCriteria<SearchConfigInfo, BaseSelectMapper> globalId() {
        this.fieldName="global_id";
        return new SelectCriteria<>(this.splicingParam, this.fieldName,SearchConfigInfo.class, BaseSelectMapper.class);
        }


        public SelectCriteria<SearchConfigInfo, BaseSelectMapper> searchConfigId() {
        this.fieldName="search_config_id";
        return new SelectCriteria<>(this.splicingParam, this.fieldName,SearchConfigInfo.class, BaseSelectMapper.class);
        }


        public SelectCriteria<SearchConfigInfo, BaseSelectMapper> pageTag() {
        this.fieldName="page_tag";
        return new SelectCriteria<>(this.splicingParam, this.fieldName,SearchConfigInfo.class, BaseSelectMapper.class);
        }


        public SelectCriteria<SearchConfigInfo, BaseSelectMapper> searchName() {
        this.fieldName="search_name";
        return new SelectCriteria<>(this.splicingParam, this.fieldName,SearchConfigInfo.class, BaseSelectMapper.class);
        }


        public SelectCriteria<SearchConfigInfo, BaseSelectMapper> searchKey() {
        this.fieldName="search_key";
        return new SelectCriteria<>(this.splicingParam, this.fieldName,SearchConfigInfo.class, BaseSelectMapper.class);
        }


        public SelectCriteria<SearchConfigInfo, BaseSelectMapper> limitSearchConditions() {
        this.fieldName="limit_search_conditions";
        return new SelectCriteria<>(this.splicingParam, this.fieldName,SearchConfigInfo.class, BaseSelectMapper.class);
        }


        public SelectCriteria<SearchConfigInfo, BaseSelectMapper> limitSearchValues() {
        this.fieldName="limit_search_values";
        return new SelectCriteria<>(this.splicingParam, this.fieldName,SearchConfigInfo.class, BaseSelectMapper.class);
        }


        public SelectCriteria<SearchConfigInfo, BaseSelectMapper> searchValueSource() {
        this.fieldName="search_value_source";
        return new SelectCriteria<>(this.splicingParam, this.fieldName,SearchConfigInfo.class, BaseSelectMapper.class);
        }


        public SelectCriteria<SearchConfigInfo, BaseSelectMapper> searchType() {
        this.fieldName="search_type";
        return new SelectCriteria<>(this.splicingParam, this.fieldName,SearchConfigInfo.class, BaseSelectMapper.class);
        }


        public SelectCriteria<SearchConfigInfo, BaseSelectMapper> sortNum() {
        this.fieldName="sort_num";
        return new SelectCriteria<>(this.splicingParam, this.fieldName,SearchConfigInfo.class, BaseSelectMapper.class);
        }


        public SelectCriteria<SearchConfigInfo, BaseSelectMapper> hidden() {
        this.fieldName="hidden";
        return new SelectCriteria<>(this.splicingParam, this.fieldName,SearchConfigInfo.class, BaseSelectMapper.class);
        }


        public SelectCriteria<SearchConfigInfo, BaseSelectMapper> defaultOrderBy() {
        this.fieldName="default_order_by";
        return new SelectCriteria<>(this.splicingParam, this.fieldName,SearchConfigInfo.class, BaseSelectMapper.class);
        }


        public SelectCriteria<SearchConfigInfo, BaseSelectMapper> defaultOrderByDesc() {
        this.fieldName="default_order_by_desc";
        return new SelectCriteria<>(this.splicingParam, this.fieldName,SearchConfigInfo.class, BaseSelectMapper.class);
        }


        public SelectCriteria<SearchConfigInfo, BaseSelectMapper> createTime() {
        this.fieldName="create_time";
        return new SelectCriteria<>(this.splicingParam, this.fieldName,SearchConfigInfo.class, BaseSelectMapper.class);
        }


        public SelectCriteria<SearchConfigInfo, BaseSelectMapper> updataTime() {
        this.fieldName="updata_time";
        return new SelectCriteria<>(this.splicingParam, this.fieldName,SearchConfigInfo.class, BaseSelectMapper.class);
        }


        public SelectCriteria<SearchConfigInfo, BaseSelectMapper> deleted() {
        this.fieldName="deleted";
        return new SelectCriteria<>(this.splicingParam, this.fieldName,SearchConfigInfo.class, BaseSelectMapper.class);
        }

}

public static class BaseUpdateMapper extends BaseUpdateAction<SearchConfigInfo, BaseUpdateMapper> {

        public BaseUpdateMapper(SplicingParam splicingParam) {
            super(splicingParam,SearchConfigInfo.class, BaseUpdateMapper.class);
        }

        public UpdateCriteria<SearchConfigInfo, BaseUpdateMapper> id() {
        this.fieldName="id";
        return new UpdateCriteria<>(this.splicingParam,this.fieldName,SearchConfigInfo.class, BaseUpdateMapper.class);
        }


        public UpdateCriteria<SearchConfigInfo, BaseUpdateMapper> globalId() {
        this.fieldName="global_id";
        return new UpdateCriteria<>(this.splicingParam,this.fieldName,SearchConfigInfo.class, BaseUpdateMapper.class);
        }


        public UpdateCriteria<SearchConfigInfo, BaseUpdateMapper> searchConfigId() {
        this.fieldName="search_config_id";
        return new UpdateCriteria<>(this.splicingParam,this.fieldName,SearchConfigInfo.class, BaseUpdateMapper.class);
        }


        public UpdateCriteria<SearchConfigInfo, BaseUpdateMapper> pageTag() {
        this.fieldName="page_tag";
        return new UpdateCriteria<>(this.splicingParam,this.fieldName,SearchConfigInfo.class, BaseUpdateMapper.class);
        }


        public UpdateCriteria<SearchConfigInfo, BaseUpdateMapper> searchName() {
        this.fieldName="search_name";
        return new UpdateCriteria<>(this.splicingParam,this.fieldName,SearchConfigInfo.class, BaseUpdateMapper.class);
        }


        public UpdateCriteria<SearchConfigInfo, BaseUpdateMapper> searchKey() {
        this.fieldName="search_key";
        return new UpdateCriteria<>(this.splicingParam,this.fieldName,SearchConfigInfo.class, BaseUpdateMapper.class);
        }


        public UpdateCriteria<SearchConfigInfo, BaseUpdateMapper> limitSearchConditions() {
        this.fieldName="limit_search_conditions";
        return new UpdateCriteria<>(this.splicingParam,this.fieldName,SearchConfigInfo.class, BaseUpdateMapper.class);
        }


        public UpdateCriteria<SearchConfigInfo, BaseUpdateMapper> limitSearchValues() {
        this.fieldName="limit_search_values";
        return new UpdateCriteria<>(this.splicingParam,this.fieldName,SearchConfigInfo.class, BaseUpdateMapper.class);
        }


        public UpdateCriteria<SearchConfigInfo, BaseUpdateMapper> searchValueSource() {
        this.fieldName="search_value_source";
        return new UpdateCriteria<>(this.splicingParam,this.fieldName,SearchConfigInfo.class, BaseUpdateMapper.class);
        }


        public UpdateCriteria<SearchConfigInfo, BaseUpdateMapper> searchType() {
        this.fieldName="search_type";
        return new UpdateCriteria<>(this.splicingParam,this.fieldName,SearchConfigInfo.class, BaseUpdateMapper.class);
        }


        public UpdateCriteria<SearchConfigInfo, BaseUpdateMapper> sortNum() {
        this.fieldName="sort_num";
        return new UpdateCriteria<>(this.splicingParam,this.fieldName,SearchConfigInfo.class, BaseUpdateMapper.class);
        }


        public UpdateCriteria<SearchConfigInfo, BaseUpdateMapper> hidden() {
        this.fieldName="hidden";
        return new UpdateCriteria<>(this.splicingParam,this.fieldName,SearchConfigInfo.class, BaseUpdateMapper.class);
        }


        public UpdateCriteria<SearchConfigInfo, BaseUpdateMapper> defaultOrderBy() {
        this.fieldName="default_order_by";
        return new UpdateCriteria<>(this.splicingParam,this.fieldName,SearchConfigInfo.class, BaseUpdateMapper.class);
        }


        public UpdateCriteria<SearchConfigInfo, BaseUpdateMapper> defaultOrderByDesc() {
        this.fieldName="default_order_by_desc";
        return new UpdateCriteria<>(this.splicingParam,this.fieldName,SearchConfigInfo.class, BaseUpdateMapper.class);
        }


        public UpdateCriteria<SearchConfigInfo, BaseUpdateMapper> createTime() {
        this.fieldName="create_time";
        return new UpdateCriteria<>(this.splicingParam,this.fieldName,SearchConfigInfo.class, BaseUpdateMapper.class);
        }


        public UpdateCriteria<SearchConfigInfo, BaseUpdateMapper> updataTime() {
        this.fieldName="updata_time";
        return new UpdateCriteria<>(this.splicingParam,this.fieldName,SearchConfigInfo.class, BaseUpdateMapper.class);
        }


        public UpdateCriteria<SearchConfigInfo, BaseUpdateMapper> deleted() {
        this.fieldName="deleted";
        return new UpdateCriteria<>(this.splicingParam,this.fieldName,SearchConfigInfo.class, BaseUpdateMapper.class);
        }

}

public static class BaseDeletedMapper extends BaseDeletedAction<SearchConfigInfo, BaseDeletedMapper> {
        public BaseDeletedMapper(SplicingParam splicingParam) {
        super(splicingParam,SearchConfigInfo.class, BaseDeletedMapper.class);
        }


        public DeletedCriteria<SearchConfigInfo, BaseDeletedMapper> id() {
        this.fieldName="id";
        return new DeletedCriteria<>(this.splicingParam,this.fieldName,SearchConfigInfo.class, BaseDeletedMapper.class);
        }


        public DeletedCriteria<SearchConfigInfo, BaseDeletedMapper> globalId() {
        this.fieldName="global_id";
        return new DeletedCriteria<>(this.splicingParam,this.fieldName,SearchConfigInfo.class, BaseDeletedMapper.class);
        }


        public DeletedCriteria<SearchConfigInfo, BaseDeletedMapper> searchConfigId() {
        this.fieldName="search_config_id";
        return new DeletedCriteria<>(this.splicingParam,this.fieldName,SearchConfigInfo.class, BaseDeletedMapper.class);
        }


        public DeletedCriteria<SearchConfigInfo, BaseDeletedMapper> pageTag() {
        this.fieldName="page_tag";
        return new DeletedCriteria<>(this.splicingParam,this.fieldName,SearchConfigInfo.class, BaseDeletedMapper.class);
        }


        public DeletedCriteria<SearchConfigInfo, BaseDeletedMapper> searchName() {
        this.fieldName="search_name";
        return new DeletedCriteria<>(this.splicingParam,this.fieldName,SearchConfigInfo.class, BaseDeletedMapper.class);
        }


        public DeletedCriteria<SearchConfigInfo, BaseDeletedMapper> searchKey() {
        this.fieldName="search_key";
        return new DeletedCriteria<>(this.splicingParam,this.fieldName,SearchConfigInfo.class, BaseDeletedMapper.class);
        }


        public DeletedCriteria<SearchConfigInfo, BaseDeletedMapper> limitSearchConditions() {
        this.fieldName="limit_search_conditions";
        return new DeletedCriteria<>(this.splicingParam,this.fieldName,SearchConfigInfo.class, BaseDeletedMapper.class);
        }


        public DeletedCriteria<SearchConfigInfo, BaseDeletedMapper> limitSearchValues() {
        this.fieldName="limit_search_values";
        return new DeletedCriteria<>(this.splicingParam,this.fieldName,SearchConfigInfo.class, BaseDeletedMapper.class);
        }


        public DeletedCriteria<SearchConfigInfo, BaseDeletedMapper> searchValueSource() {
        this.fieldName="search_value_source";
        return new DeletedCriteria<>(this.splicingParam,this.fieldName,SearchConfigInfo.class, BaseDeletedMapper.class);
        }


        public DeletedCriteria<SearchConfigInfo, BaseDeletedMapper> searchType() {
        this.fieldName="search_type";
        return new DeletedCriteria<>(this.splicingParam,this.fieldName,SearchConfigInfo.class, BaseDeletedMapper.class);
        }


        public DeletedCriteria<SearchConfigInfo, BaseDeletedMapper> sortNum() {
        this.fieldName="sort_num";
        return new DeletedCriteria<>(this.splicingParam,this.fieldName,SearchConfigInfo.class, BaseDeletedMapper.class);
        }


        public DeletedCriteria<SearchConfigInfo, BaseDeletedMapper> hidden() {
        this.fieldName="hidden";
        return new DeletedCriteria<>(this.splicingParam,this.fieldName,SearchConfigInfo.class, BaseDeletedMapper.class);
        }


        public DeletedCriteria<SearchConfigInfo, BaseDeletedMapper> defaultOrderBy() {
        this.fieldName="default_order_by";
        return new DeletedCriteria<>(this.splicingParam,this.fieldName,SearchConfigInfo.class, BaseDeletedMapper.class);
        }


        public DeletedCriteria<SearchConfigInfo, BaseDeletedMapper> defaultOrderByDesc() {
        this.fieldName="default_order_by_desc";
        return new DeletedCriteria<>(this.splicingParam,this.fieldName,SearchConfigInfo.class, BaseDeletedMapper.class);
        }


        public DeletedCriteria<SearchConfigInfo, BaseDeletedMapper> createTime() {
        this.fieldName="create_time";
        return new DeletedCriteria<>(this.splicingParam,this.fieldName,SearchConfigInfo.class, BaseDeletedMapper.class);
        }


        public DeletedCriteria<SearchConfigInfo, BaseDeletedMapper> updataTime() {
        this.fieldName="updata_time";
        return new DeletedCriteria<>(this.splicingParam,this.fieldName,SearchConfigInfo.class, BaseDeletedMapper.class);
        }


        public DeletedCriteria<SearchConfigInfo, BaseDeletedMapper> deleted() {
        this.fieldName="deleted";
        return new DeletedCriteria<>(this.splicingParam,this.fieldName,SearchConfigInfo.class, BaseDeletedMapper.class);
        }

    }
}
