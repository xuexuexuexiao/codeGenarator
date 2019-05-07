package com.example.demo.DO;

import lombok.Data;

/**
 * @author Huxiaoxue
 * @version V1.0
 * @ClassName
 * @desc:
 * @create: 2019-05-07
 **/
@Data
public class QueryCondition {

    private String queryCode;

    private QueryParams queryParams;


    public QueryCondition(String queryCode){
        this.queryCode = queryCode;
    }

    public QueryCondition(String queryCode,QueryParams params){
        this.queryCode = queryCode;
        this.queryParams = params;
    }
}
