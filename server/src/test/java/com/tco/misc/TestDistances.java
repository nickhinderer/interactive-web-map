package com.tco.misc;

import com.tco.misc.Distances;
import com.tco.misc.Places;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;

import static org.junit.jupiter.api.Assertions.*;

public class TestDistances {

    private Distances conf;

    @BeforeEach
    public void createConfigurationForTestCases() {
        conf = new Distances();
        conf.computeDistances();
    }

    @Test
    @DisplayName("Places is correct")
    public void testPlaces() {
        assertNotNull(conf.getPlaces());
    }

    @Test
    @DisplayName("earthRadius is correct")
    public void testEarthRadius() {
        assertEquals(0, conf.getEarthRadius());
    }

    @Test
    @DisplayName("Distances is correct")
    public void testDistances() {
        assertNotNull(conf.getDistances());
        assertEquals(2, conf.getDistances().size());
        assertEquals(0, conf.getDistances().get(0));
    }

    @Test
    @DisplayName("constructor works properly")
    public void testConstructor() {
        Distances constructorTest = new Distances(new Places(), 0.0);
        assertNotNull(constructorTest);
        assertEquals(new Places(), constructorTest.getPlaces());
        assertEquals(0.0, constructorTest.getEarthRadius());
    }

}
