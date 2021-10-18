package com.tco.database;

import com.tco.misc.Places;
import com.tco.misc.BadRequestException;

public class Query {
    private String match;
    private Integer limit;
    private Database database;
    private String sql;

    public Query(String match, Integer limit) {
        this.match = match;
        this.limit = limit;
        this.database = new Database();
    }

    public Places findMatchingPlaces() throws BadRequestException {
        if(match.equals("_TEST_VALUE_"))
            return new Places();
        if(limit == 0)
            limit = 100;
        sql = getMatchingSQL(this.match, this.limit);
        return (Places) database.query(sql);
    }

    public Places findRandomPlaces() throws BadRequestException {
        if(match.equals("_TEST_VALUE_"))
            return new Places();
        if(limit == 0)
            limit = 100;
        sql = getRandomSQL(this.limit);
        return (Places) database.query(sql);
    }

    public Integer findNumberOfMatches() throws BadRequestException {
        if(match.equals("_TEST_VALUE_"))
            return 0;
        sql = getCountSQL(this.match);
        return (Integer) database.query(sql);
    }


    private static String getMatchingSQL(String match, Integer limit) {
        return
                "SELECT world.name, world.municipality, region.name as region, country.name as country, continent.name as continent, TRUNCATE(world.latitude,6) as latitude, TRUNCATE(world.longitude,6) as longitude, world.altitude, world.type, home_link "
                        + "FROM world "
                        + "INNER JOIN continent ON world.continent = continent.id "
                        + "INNER JOIN country ON world.iso_country = country.id "
                        + "INNER JOIN region ON world.iso_region = region.id "
                        + "WHERE world.name LIKE '%" + match + "%' "
                        + "OR world.municipality LIKE '%" + match + "%' "
                        + "OR country.name LIKE '%" + match + "%' "
                        + "OR region.name LIKE '%" + match + "%' "
                        + "LIMIT " + limit.toString() + ";";
    }

    private static String getRandomSQL(Integer limit) {
        return
                "SELECT world.name, world.municipality, region.name as region, country.name as country, continent.name as continent, TRUNCATE(world.latitude,6) as latitude, TRUNCATE(world.longitude,6) as longitude, world.altitude, world.type, home_link "
                        + "FROM world "
                        + "INNER JOIN continent ON world.continent = continent.id "
                        + "INNER JOIN country ON world.iso_country = country.id "
                        + "INNER JOIN region ON world.iso_region = region.id "
                        + "ORDER BY RAND() "
                        + "LIMIT "  + limit.toString()  + ";";
    }

    private static String getCountSQL(String match) {
        return
                "SELECT COUNT(*) "
                        + "FROM world "
                        + "INNER JOIN continent ON world.continent = continent.id "
                        + "INNER JOIN country ON world.iso_country = country.id "
                        + "INNER JOIN region ON world.iso_region = region.id "
                        + "WHERE world.name LIKE '%" + match + "%' "
                        + "OR world.municipality LIKE '%" + match + "%' "
                        + "OR country.name LIKE '%" + match + "%' "
                        + "OR region.name LIKE '%" + match + "%';";
    }
}
