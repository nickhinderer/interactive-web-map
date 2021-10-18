package com.tco.misc;

import com.tco.database.Query;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;

import static org.junit.jupiter.api.Assertions.*;

public class TestQuery {

    private Query query;

    @BeforeEach
    public void createQueryForTestCases() {
        query = new Query();
    }

    @Test
    @DisplayName("Match is correct")
    public void testMatch() {
        assertEquals("", query.getMatch());
    }

    @Test
    @DisplayName("Limit is correct")
    public void testLimit() {
        assertEquals(0, query.getLimit());
    }

    @Test
    @DisplayName("Database is not null")
    public void testDatabase() {
        assertNotNull(query.getDatabase());
    }

    @Test
    @DisplayName("Random SQL works")
    public void testRandomSQL() {
        assertEquals("SELECT world.name, world.municipality, region.name as region, country.name as country, continent.name as continent, TRUNCATE(world.latitude,6) as latitude, TRUNCATE(world.longitude,6) as longitude, world.altitude, world.type, home_link FROM world INNER JOIN continent ON world.continent = continent.id INNER JOIN country ON world.iso_country = country.id INNER JOIN region ON world.iso_region = region.id ORDER BY RAND() LIMIT 0;", query.getRandomSQL());
    }

    @Test
    @DisplayName("Match SQL works")
    public void testMatchingSQL() {
        assertEquals("SELECT world.name, world.municipality, region.name as region, country.name as country, continent.name as continent, TRUNCATE(world.latitude,6) as latitude, TRUNCATE(world.longitude,6) as longitude, world.altitude, world.type, home_link FROM world INNER JOIN continent ON world.continent = continent.id INNER JOIN country ON world.iso_country = country.id INNER JOIN region ON world.iso_region = region.id WHERE world.name LIKE '%%' OR world.municipality LIKE '%%' OR country.name LIKE '%%' OR region.name LIKE '%%' LIMIT 0;", query.getMatchingSQL());
    }

    @Test
    @DisplayName("Count SQL works")
    public void testCountSQL() {
        assertEquals("SELECT COUNT(*) FROM world INNER JOIN continent ON world.continent = continent.id INNER JOIN country ON world.iso_country = country.id INNER JOIN region ON world.iso_region = region.id WHERE world.name LIKE '%%' OR world.municipality LIKE '%%' OR country.name LIKE '%%' OR region.name LIKE '%%';", query.getCountSQL());

    }
}
