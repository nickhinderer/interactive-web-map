package com.tco.database;

import com.tco.requests.*;
import com.tco.misc.BadRequestException;

public class Query {
    private String match;
    private Integer limit;
    private Database database;

    public Query(String match, Integer limit) {
        this.match = match;
        this.limit = limit;
        this.database = new Database();
    }

    public Places findMatchingPlaces() throws BadRequestException {
        if(limit == 0)
            limit = 100;
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
                    "SELECT "
                            + "COUNT(*) "
                            + "FROM world "
                            + "WHERE name LIKE '%" + match + "%' "
                            + "OR municipality LIKE '%" + match + "%' "
                            + "OR iso_region LIKE '%" + match + "%' "
                            + "OR iso_country LIKE '%" + match
                            + "%';";
        } else if(match.equals("")) {
            return
                    "SELECT "
                            + "name, TRUNCATE(latitude,6), TRUNCATE(longitude,6), altitude, type, iso_country, home_link "
                            + "FROM world ORDER BY RAND() "
                            + "LIMIT "  + limit.toString()  + ";";

        } else {
            return
                    "SELECT "
                            + "name, TRUNCATE(latitude,6), TRUNCATE(longitude,6), altitude, type, iso_country, home_link "
                            + "FROM world "
                            + "WHERE name LIKE '%" + match + "%' "
                            + "OR municipality LIKE '%" + match + "%' "
                            + "OR iso_region LIKE '%" + match + "%' "
                            + "OR iso_country LIKE '%" + match + "%' "
                            + "%' LIMIT "  + limit.toString()  + ";";
        }//add join table too. and type and where

    }
}