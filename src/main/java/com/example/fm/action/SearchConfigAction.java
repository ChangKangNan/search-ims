package com.example.fm.action;
import cn.ft.ckn.fastmapper.component.*;
import com.example.fm.bean.SearchConfig;

public class SearchConfigAction {
public static class InsertMapper extends InsertDao<SearchConfig, InsertMapper> {
        public InsertMapper(SplicingParam splicingParam){
        super(splicingParam,SearchConfig.class, InsertMapper.class);
        }
}

public static class BaseSelectMapper extends BaseSelectAction<SearchConfig, BaseSelectMapper> {
        public BaseSelectMapper(SplicingParam splicingParam) {
        super(splicingParam,SearchConfig.class, BaseSelectMapper.class);
        }


        public SelectCriteria<SearchConfig, BaseSelectMapper> id() {
        this.fieldName="id";
        return new SelectCriteria<>(this.splicingParam, this.fieldName,SearchConfig.class, BaseSelectMapper.class);
        }


        public SelectCriteria<SearchConfig, BaseSelectMapper> globalId() {
        this.fieldName="global_id";
        return new SelectCriteria<>(this.splicingParam, this.fieldName,SearchConfig.class, BaseSelectMapper.class);
        }


        public SelectCriteria<SearchConfig, BaseSelectMapper> configName() {
        this.fieldName="config_name";
        return new SelectCriteria<>(this.splicingParam, this.fieldName,SearchConfig.class, BaseSelectMapper.class);
        }


        public SelectCriteria<SearchConfig, BaseSelectMapper> pageTag() {
        this.fieldName="page_tag";
        return new SelectCriteria<>(this.splicingParam, this.fieldName,SearchConfig.class, BaseSelectMapper.class);
        }


        public SelectCriteria<SearchConfig, BaseSelectMapper> hash() {
        this.fieldName="hash";
        return new SelectCriteria<>(this.splicingParam, this.fieldName,SearchConfig.class, BaseSelectMapper.class);
        }


        public SelectCriteria<SearchConfig, BaseSelectMapper> version() {
        this.fieldName="version";
        return new SelectCriteria<>(this.splicingParam, this.fieldName,SearchConfig.class, BaseSelectMapper.class);
        }


        public SelectCriteria<SearchConfig, BaseSelectMapper> searchSql() {
        this.fieldName="search_sql";
        return new SelectCriteria<>(this.splicingParam, this.fieldName,SearchConfig.class, BaseSelectMapper.class);
        }


        public SelectCriteria<SearchConfig, BaseSelectMapper> useOrgLimitTableAlias() {
        this.fieldName="use_org_limit_table_alias";
        return new SelectCriteria<>(this.splicingParam, this.fieldName,SearchConfig.class, BaseSelectMapper.class);
        }


        public SelectCriteria<SearchConfig, BaseSelectMapper> useOrgsLimitTableAlias() {
        this.fieldName="use_orgs_limit_table_alias";
        return new SelectCriteria<>(this.splicingParam, this.fieldName,SearchConfig.class, BaseSelectMapper.class);
        }


        public SelectCriteria<SearchConfig, BaseSelectMapper> remark() {
        this.fieldName="remark";
        return new SelectCriteria<>(this.splicingParam, this.fieldName,SearchConfig.class, BaseSelectMapper.class);
        }


        public SelectCriteria<SearchConfig, BaseSelectMapper> createTime() {
        this.fieldName="create_time";
        return new SelectCriteria<>(this.splicingParam, this.fieldName,SearchConfig.class, BaseSelectMapper.class);
        }


        public SelectCriteria<SearchConfig, BaseSelectMapper> updataTime() {
        this.fieldName="updata_time";
        return new SelectCriteria<>(this.splicingParam, this.fieldName,SearchConfig.class, BaseSelectMapper.class);
        }


        public SelectCriteria<SearchConfig, BaseSelectMapper> deleted() {
        this.fieldName="deleted";
        return new SelectCriteria<>(this.splicingParam, this.fieldName,SearchConfig.class, BaseSelectMapper.class);
        }

}

public static class BaseUpdateMapper extends BaseUpdateAction<SearchConfig, BaseUpdateMapper> {

        public BaseUpdateMapper(SplicingParam splicingParam) {
            super(splicingParam,SearchConfig.class, BaseUpdateMapper.class);
        }

        public UpdateCriteria<SearchConfig, BaseUpdateMapper> id() {
        this.fieldName="id";
        return new UpdateCriteria<>(this.splicingParam,this.fieldName,SearchConfig.class, BaseUpdateMapper.class);
        }


        public UpdateCriteria<SearchConfig, BaseUpdateMapper> globalId() {
        this.fieldName="global_id";
        return new UpdateCriteria<>(this.splicingParam,this.fieldName,SearchConfig.class, BaseUpdateMapper.class);
        }


        public UpdateCriteria<SearchConfig, BaseUpdateMapper> configName() {
        this.fieldName="config_name";
        return new UpdateCriteria<>(this.splicingParam,this.fieldName,SearchConfig.class, BaseUpdateMapper.class);
        }


        public UpdateCriteria<SearchConfig, BaseUpdateMapper> pageTag() {
        this.fieldName="page_tag";
        return new UpdateCriteria<>(this.splicingParam,this.fieldName,SearchConfig.class, BaseUpdateMapper.class);
        }


        public UpdateCriteria<SearchConfig, BaseUpdateMapper> hash() {
        this.fieldName="hash";
        return new UpdateCriteria<>(this.splicingParam,this.fieldName,SearchConfig.class, BaseUpdateMapper.class);
        }


        public UpdateCriteria<SearchConfig, BaseUpdateMapper> version() {
        this.fieldName="version";
        return new UpdateCriteria<>(this.splicingParam,this.fieldName,SearchConfig.class, BaseUpdateMapper.class);
        }


        public UpdateCriteria<SearchConfig, BaseUpdateMapper> searchSql() {
        this.fieldName="search_sql";
        return new UpdateCriteria<>(this.splicingParam,this.fieldName,SearchConfig.class, BaseUpdateMapper.class);
        }


        public UpdateCriteria<SearchConfig, BaseUpdateMapper> useOrgLimitTableAlias() {
        this.fieldName="use_org_limit_table_alias";
        return new UpdateCriteria<>(this.splicingParam,this.fieldName,SearchConfig.class, BaseUpdateMapper.class);
        }


        public UpdateCriteria<SearchConfig, BaseUpdateMapper> useOrgsLimitTableAlias() {
        this.fieldName="use_orgs_limit_table_alias";
        return new UpdateCriteria<>(this.splicingParam,this.fieldName,SearchConfig.class, BaseUpdateMapper.class);
        }


        public UpdateCriteria<SearchConfig, BaseUpdateMapper> remark() {
        this.fieldName="remark";
        return new UpdateCriteria<>(this.splicingParam,this.fieldName,SearchConfig.class, BaseUpdateMapper.class);
        }


        public UpdateCriteria<SearchConfig, BaseUpdateMapper> createTime() {
        this.fieldName="create_time";
        return new UpdateCriteria<>(this.splicingParam,this.fieldName,SearchConfig.class, BaseUpdateMapper.class);
        }


        public UpdateCriteria<SearchConfig, BaseUpdateMapper> updataTime() {
        this.fieldName="updata_time";
        return new UpdateCriteria<>(this.splicingParam,this.fieldName,SearchConfig.class, BaseUpdateMapper.class);
        }


        public UpdateCriteria<SearchConfig, BaseUpdateMapper> deleted() {
        this.fieldName="deleted";
        return new UpdateCriteria<>(this.splicingParam,this.fieldName,SearchConfig.class, BaseUpdateMapper.class);
        }

}

public static class BaseDeletedMapper extends BaseDeletedAction<SearchConfig, BaseDeletedMapper> {
        public BaseDeletedMapper(SplicingParam splicingParam) {
        super(splicingParam,SearchConfig.class, BaseDeletedMapper.class);
        }


        public DeletedCriteria<SearchConfig, BaseDeletedMapper> id() {
        this.fieldName="id";
        return new DeletedCriteria<>(this.splicingParam,this.fieldName,SearchConfig.class, BaseDeletedMapper.class);
        }


        public DeletedCriteria<SearchConfig, BaseDeletedMapper> globalId() {
        this.fieldName="global_id";
        return new DeletedCriteria<>(this.splicingParam,this.fieldName,SearchConfig.class, BaseDeletedMapper.class);
        }


        public DeletedCriteria<SearchConfig, BaseDeletedMapper> configName() {
        this.fieldName="config_name";
        return new DeletedCriteria<>(this.splicingParam,this.fieldName,SearchConfig.class, BaseDeletedMapper.class);
        }


        public DeletedCriteria<SearchConfig, BaseDeletedMapper> pageTag() {
        this.fieldName="page_tag";
        return new DeletedCriteria<>(this.splicingParam,this.fieldName,SearchConfig.class, BaseDeletedMapper.class);
        }


        public DeletedCriteria<SearchConfig, BaseDeletedMapper> hash() {
        this.fieldName="hash";
        return new DeletedCriteria<>(this.splicingParam,this.fieldName,SearchConfig.class, BaseDeletedMapper.class);
        }


        public DeletedCriteria<SearchConfig, BaseDeletedMapper> version() {
        this.fieldName="version";
        return new DeletedCriteria<>(this.splicingParam,this.fieldName,SearchConfig.class, BaseDeletedMapper.class);
        }


        public DeletedCriteria<SearchConfig, BaseDeletedMapper> searchSql() {
        this.fieldName="search_sql";
        return new DeletedCriteria<>(this.splicingParam,this.fieldName,SearchConfig.class, BaseDeletedMapper.class);
        }


        public DeletedCriteria<SearchConfig, BaseDeletedMapper> useOrgLimitTableAlias() {
        this.fieldName="use_org_limit_table_alias";
        return new DeletedCriteria<>(this.splicingParam,this.fieldName,SearchConfig.class, BaseDeletedMapper.class);
        }


        public DeletedCriteria<SearchConfig, BaseDeletedMapper> useOrgsLimitTableAlias() {
        this.fieldName="use_orgs_limit_table_alias";
        return new DeletedCriteria<>(this.splicingParam,this.fieldName,SearchConfig.class, BaseDeletedMapper.class);
        }


        public DeletedCriteria<SearchConfig, BaseDeletedMapper> remark() {
        this.fieldName="remark";
        return new DeletedCriteria<>(this.splicingParam,this.fieldName,SearchConfig.class, BaseDeletedMapper.class);
        }


        public DeletedCriteria<SearchConfig, BaseDeletedMapper> createTime() {
        this.fieldName="create_time";
        return new DeletedCriteria<>(this.splicingParam,this.fieldName,SearchConfig.class, BaseDeletedMapper.class);
        }


        public DeletedCriteria<SearchConfig, BaseDeletedMapper> updataTime() {
        this.fieldName="updata_time";
        return new DeletedCriteria<>(this.splicingParam,this.fieldName,SearchConfig.class, BaseDeletedMapper.class);
        }


        public DeletedCriteria<SearchConfig, BaseDeletedMapper> deleted() {
        this.fieldName="deleted";
        return new DeletedCriteria<>(this.splicingParam,this.fieldName,SearchConfig.class, BaseDeletedMapper.class);
        }

    }
}
