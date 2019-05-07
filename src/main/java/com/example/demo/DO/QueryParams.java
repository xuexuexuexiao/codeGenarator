package com.example.demo.DO;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author Huxiaoxue
 * @version V1.0
 * @ClassName
 * @desc: 查询参数
 * @create: 2019-04-12
 **/
public class QueryParams extends LinkedHashMap<String, Object> {

    private static final long serialVersionUID = 1L;
    //
    private int offset;
    // 每页条数
    private int limit;

    /**
     * 查询参数封装
     * @param params   前端传递的查询参数
     */
    public QueryParams(Map<String, Object> params) {
        this.putAll(params);
        // 分页参数
        this.offset = Integer.parseInt(params.get("offset").toString());
        this.limit = Integer.parseInt(params.get("limit").toString());
        this.put("offset", offset);
        this.put("page", offset / limit + 1);
        this.put("limit", limit);
    }

    public int getOffset() {
        return offset;
    }

    public void setOffset(int offset) {
        this.put("offset", offset);
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }
}
