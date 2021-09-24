package com.tco.database;

public class Query {
    private String match;
    private Integer limit;

    public Query(String match, Integer limit){
        this.match = match;
        this.limit = limit;
    }
}
