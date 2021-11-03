package com.tco.misc;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TestTour {

    Tour tour;

    @BeforeEach
    public void createConfigurationForTestCases() {
        tour = new Tour();
    }

    @Test
    @DisplayName("places is correct")
    public void testPlaces() {
        assertNotNull(tour.getPlaces());
    }

    @Test
    @DisplayName("earthRadius is correct")
    public void testEarthRadius() {
        assertEquals(3958.8, tour.getEarthRadius());
    }

    @Test
    @DisplayName("response is correct")
    public void testResponse() {
        assertEquals(1.0, tour.getResponse());
    }

    @Test
    @DisplayName("first test case succeeded")
    public void testOptimizeTourCase1() {
        Place place1 = new Place();
        place1.put("latitude", "47.90596");
        place1.put("longitude", "-89.90065");

        Place place2 = new Place();
        place2.put("latitude", "47.6679");
        place2.put("longitude", "-88.96132");

        Place place3 = new Place();
        place3.put("latitude", "47.66916");
        place3.put("longitude", "-90.43648");

        Place place4 = new Place();
        place4.put("latitude", "47.3947");
        place4.put("longitude", "-90.45571");

        Place place5 = new Place();
        place5.put("latitude", "47.37053");
        place5.put("longitude", "-88.95196");

        Place place6 = new Place();
        place6.put("latitude", "47.28676");
        place6.put("longitude", "-89.89403");

        //set random order for places
        //set places
        tour.optimizeTour();

        //assertEquals(188l, tour.getTourDistance());
        //also make simple tests for earthRadius and response

    }
}
