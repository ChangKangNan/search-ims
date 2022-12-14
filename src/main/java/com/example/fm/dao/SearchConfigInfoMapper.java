package com.example.fm.dao;
import cn.ft.ckn.fastmapper.component.SplicingParam;
import com.example.fm.action.SearchConfigInfoAction;

public class SearchConfigInfoMapper {
    private SearchConfigInfoMapper() {}

    public static SearchConfigInfoAction.InsertMapper lambdaInsert() {
    return new SearchConfigInfoAction.InsertMapper(new SplicingParam());
  }
    public static SearchConfigInfoAction.BaseSelectMapper lambdaQuery() {
        return new SearchConfigInfoAction.BaseSelectMapper(new SplicingParam());
  }
    public static SearchConfigInfoAction.BaseUpdateMapper lambdaUpdate() {
        return new SearchConfigInfoAction.BaseUpdateMapper(new SplicingParam());
  }
    public static SearchConfigInfoAction.BaseDeletedMapper lambdaDelete() {
        return new SearchConfigInfoAction.BaseDeletedMapper(new SplicingParam());
  }
}
