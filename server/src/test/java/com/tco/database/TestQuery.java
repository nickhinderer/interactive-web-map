package com.tco.database;

import com.tco.database.Query;

import com.tco.misc.BadRequestException;
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
        assertEquals("_QUERY_TEST_VALUE_", query.getMatch());
    }

    @Test
    @DisplayName("Limit is correct")
    public void testLimit() {
        assertEquals(-1, query.getLimit());
    }

    @Test
    @DisplayName("Database is not null")
    public void testDatabase() {
        assertNotNull(query.getDatabase());
    }

    @Test
    @DisplayName("Random SQL works")
    public void testRandomSQL() {
        assertEquals("SELECT world.name, world.municipality, region.name as region, country.name as country, continent.name as continent, TRUNCATE(world.latitude,6) as latitude, TRUNCATE(world.longitude,6) as longitude, world.altitude, world.type, home_link FROM world INNER JOIN continent ON world.continent = continent.id INNER JOIN country ON world.iso_country = country.id INNER JOIN region ON world.iso_region = region.id ORDER BY RAND() LIMIT -1;", query.testRandomSQL());
    }

    @Test
    @DisplayName("Match SQL works")
    public void testMatchingSQL() {
        assertEquals("SELECT world.name, world.municipality, region.name as region, country.name as country, continent.name as continent, TRUNCATE(world.latitude,6) as latitude, TRUNCATE(world.longitude,6) as longitude, world.altitude, world.type, home_link FROM world INNER JOIN continent ON world.continent = continent.id INNER JOIN country ON world.iso_country = country.id INNER JOIN region ON world.iso_region = region.id WHERE world.name LIKE '%_QUERY_TEST_VALUE_%' OR world.municipality LIKE '%_QUERY_TEST_VALUE_%' OR country.name LIKE '%_QUERY_TEST_VALUE_%' OR region.name LIKE '%_QUERY_TEST_VALUE_%' LIMIT -1;", query.testMatchingSQL());
    }

    @Test
    @DisplayName("Count SQL works")
    public void testCountSQL() {
        assertEquals("SELECT COUNT(*) FROM world INNER JOIN continent ON world.continent = continent.id INNER JOIN country ON world.iso_country = country.id INNER JOIN region ON world.iso_region = region.id WHERE world.name LIKE '%_QUERY_TEST_VALUE_%' OR world.municipality LIKE '%_QUERY_TEST_VALUE_%' OR country.name LIKE '%_QUERY_TEST_VALUE_%' OR region.name LIKE '%_QUERY_TEST_VALUE_%';", query.testCountSQL());
    }

    @Test
    @DisplayName("findMatchingPlaces works")
    public void testFindMatchingPlaces() throws BadRequestException {
        assertNotNull(query.testFindMatchingPlaces());
    }

    @Test
    @DisplayName("findRandomPlaces works")
    public void testFindRandomPlaces() throws BadRequestException {
        assertNotNull(query.testFindRandomPlaces());
    }

    @Test
    @DisplayName("findNumberOfMatches works")
    public void testFindNumberOfMatches() throws BadRequestException {
        assertEquals(0, query.testFindNumberOfMatches());
    }

    @Test
    @DisplayName("query constructor works")
    public void testQueryConstructor() {
        Query constructorTest = new Query("", 0);
        assertNotNull(constructorTest);
        assertEquals("", constructorTest.getMatch());
        assertEquals(0, constructorTest.getLimit());
    }
}
