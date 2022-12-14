package com.example.fm.bean;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
* 列详情
*/
@Data
@Accessors(chain=true)
public class SearchTableColumn implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
    *主键
    */
    private Long id;

    /**
    *页面标签
    */
    private String pageTag;

    /**
    *版本号
    */
    private String version;

    /**
    *列名
    */
    private String searchTableColumn;

    /**
    *列名详情
    */
    private String searchTableColumnInfo;

    /**
    *备注
    */
    private String remark;
}