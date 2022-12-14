package com.example.generator;

import lombok.Data;

/**
 * @author ckn
 * @date 2022/8/23
 */
@Data
public class SearchType {
    private String searchType;
    private String limitSearchConditions;

    public SearchType(String searchType, String limitSearchConditions) {
        this.searchType = searchType;
        this.limitSearchConditions = limitSearchConditions;
    }
}
