package com.tco.database;

import com.tco.requests.*;
import com.tco.misc.BadRequestException;

public class Query {
    private String match;
    private Integer limit;
    private Database database;

    public Query(String match, Integer limit) throws BadRequestException {
        this.match = match;
        this.limit = limit;
        this.database = new Database();
    }

    public Places findMatchingPlaces() throws BadRequestException {
        String sql = getSQL(this.match, this.limit);
        return (Places) database.query(sql);
    }

    public Integer findNumberOfMatches() throws BadRequestException {
        String sql = getSQL(this.match, this.limit);
        return (Integer) database.query(sql);
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
