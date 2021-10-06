package com.tco.database;

import com.tco.misc.Places;
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
                "SELECT COUNT(*) "
                        + "FROM world "
                        + "INNER JOIN continent ON world.continent = continent.id "
                        + "INNER JOIN country ON world.iso_country = country.id "
                        + "INNER JOIN region ON world.iso_region = region.id "
                        + "WHERE world.name LIKE '%" + match + "%' "
                        + "OR world.municipality LIKE '%" + match + "%' "
                        + "OR country.name LIKE '%" + match + "%' "
                        + "OR region.name LIKE '%" + match + "%';";
        } else if(match.equals("")) {
            return
                    "SELECT world.name, world.municipality, region.name as region, country.name as country, continent.name as continent, TRUNCATE(world.latitude,6) as latitude, TRUNCATE(world.longitude,6) as longitude, world.altitude, world.type, home_link "
                            + "FROM world "
                            + "INNER JOIN continent ON world.continent = continent.id "
                            + "INNER JOIN country ON world.iso_country = country.id "
                            + "INNER JOIN region ON world.iso_region = region.id "
                            + "ORDER BY RAND() "
                            + "LIMIT "  + limit.toString()  + ";";

        } else {
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

            //WHERE world.name LIKE "%ter%" OR world.municipality like '%ter%' OR region.name like '%nick%' OR country.name like '%ter%'
        }//add join table too. and type and where

    }
}

   // SELECT world.name, world.municipality, region.name as region, country.name as country, continent.name as continent   FROM world  INNER JOIN continent ON world.continent = continent.id   INNER JOIN country ON world.iso_country = country.id  INNER JOIN region ON world.iso_region = region.id  WHERE world.name LIKE "%ter%" OR world.municipality like '%ter%' OR region.name like '%nick%' OR country.name like '%ter%' ORDER BY continent.name, country.name, region.name, world.municipality, world.name ASC  LIMIT 10;
