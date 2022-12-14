package com.example.fm.bean;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;


@Accessors(chain=true)
@Table(name = "se_search_config_info")
@Entity
@Data
public class SearchConfigInfo {

    @Id
    @Column(name = "id")
    private Long id;


    @Column(name = "global_id")
    private Long globalId;


    @Column(name = "search_config_id")
    private Long searchConfigId;


    @Column(name = "page_tag")
    private String pageTag;

    @Column(name = "search_name")
    private String searchName;


    @Column(name = "search_key")
    private String searchKey;


    @Column(name = "limit_search_conditions")
    private String limitSearchConditions;


    @Column(name = "limit_search_values")
    private String limitSearchValues;


    @Column(name = "search_value_source")
    private String searchValueSource;


    @Column(name = "search_type")
    private String searchType;


    @Column(name = "sort_num")
    private Integer sortNum;


    @Column(name = "hidden")
    private Boolean hidden;


    @Column(name = "default_order_by")
    private Boolean defaultOrderBy;


    @Column(name = "default_order_by_desc")
    private Boolean defaultOrderByDesc;


    @Column(name = "create_time")
    private Date createTime;


    @Column(name = "updata_time")
    private Date updataTime;


    @Column(name = "deleted")
    private Boolean deleted;


}
