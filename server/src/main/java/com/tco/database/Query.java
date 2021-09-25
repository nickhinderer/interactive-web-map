package com.tco.database;

import com.tco.requests.*;
import com.tco.misc.BadRequestException;

public class Query {
    private String match;
    private Integer limit;

    public Query(String match, Integer limit) {
        this.match = match;
        this.limit = limit;
    }

    public Places findMatchingPlaces() throws BadRequestException {
        String sql = getSQL(this.match, this.limit);
        Database db = new Database();
        return db.query(sql);
    }

    private static String getSQL(String match, Integer limit) {
        if(limit == -1) {
            return
                    "SELECT " + "name, lattitude, longitude, altitude, type, country, home_link "
                            + "FROM world WHERE name LIKE '%" + match
                            + "%';";
        } else {

            return
                    "SELECT " + "name, lattitude, longitude, altitude, type, country, home_link, "//
                            + "FROM world WHERE name like '" + match
                            + "%' LIMIT "  + limit.toString()  + ";";
        }//add join table too

    }
}
