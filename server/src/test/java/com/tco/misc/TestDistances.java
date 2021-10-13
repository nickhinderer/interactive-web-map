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
        assertEquals(1, conf.getDistances().size());
        assertEquals(0, conf.getDistances().get(0));
    }

}
