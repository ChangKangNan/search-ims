package com.example.fm.dao;
import cn.ft.ckn.fastmapper.component.SplicingParam;
import com.example.fm.action.SearchConfigAction;

public class SearchConfigMapper {
    private SearchConfigMapper() {}

    public static SearchConfigAction.InsertMapper lambdaInsert() {
    return new SearchConfigAction.InsertMapper(new SplicingParam());
  }
    public static SearchConfigAction.BaseSelectMapper lambdaQuery() {
        return new SearchConfigAction.BaseSelectMapper(new SplicingParam());
  }
    public static SearchConfigAction.BaseUpdateMapper lambdaUpdate() {
        return new SearchConfigAction.BaseUpdateMapper(new SplicingParam());
  }
    public static SearchConfigAction.BaseDeletedMapper lambdaDelete() {
        return new SearchConfigAction.BaseDeletedMapper(new SplicingParam());
  }
}
