package com.tco.database;

import com.tco.requests.*;
import com.tco.misc.BadRequestException;

public class Query {
    private String match;
    private Integer limit;

    public Query(String match, Integer limit){
        this.match = match;
        this.limit = limit;
    }

    public Places findMatchingPlaces() throws BadRequestException {
        String sql = getSQL(this.match, this.limit);
        Database db = new Database();
        return db.query(sql);
    }

    private static String getSQL(String match, Integer limit) {
        if(limit != -1) {
            return
                    "SELECT " + "iso_country "//not very useful, change in future as well as convertQu..Results in Database.java (and COLUMN etc.)
                            + "FROM world WHERE iso_country = '" + match
                            + "' LIMIT "  + limit.toString()  + ";";
        } else {
            return
                    "SELECT " + "iso_country "
                            + "FROM world WHERE iso_country = '" + match
                            + "';";
        }
    }
}
