package com.example.fm.bean;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;


@Accessors(chain=true)
@Table(name = "se_search_config")
@Entity
@Data
public class SearchConfig {

    @Id
    @Column(name = "id")
    private Long id;


    @Column(name = "global_id")
    private Long globalId;


    @Column(name = "config_name")
    private String configName;


    @Column(name = "page_tag")
    private String pageTag;


    @Column(name = "hash")
    private String hash;


    @Column(name = "version")
    private String version;


    @Column(name = "search_sql")
    private String searchSql;


    @Column(name = "use_org_limit_table_alias")
    private String useOrgLimitTableAlias;

    @Column(name = "use_orgs_limit_table_alias")
    private String useOrgsLimitTableAlias;


    @Column(name = "remark")
    private String remark;


    @Column(name = "create_time")
    private Date createTime;

    @Column(name = "updata_time")
    private Date updataTime;


    @Column(name = "deleted")
    private Boolean deleted;


}
