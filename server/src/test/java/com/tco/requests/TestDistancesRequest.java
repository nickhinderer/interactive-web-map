package com.tco.requests;

import com.tco.misc.Places;
import com.tco.misc.Distances;

import com.tco.misc.BadRequestException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class TestDistancesRequest {
    private final transient Logger log = LoggerFactory.getLogger(TestDistancesRequest.class);
    private DistancesRequest conf;

    @BeforeEach
    public void createConfigurationForTestCases() {
        conf = new DistancesRequest();
        try { // TODO: come back and handle better
            conf.buildResponse();
        } catch (BadRequestException e) {
            log.error("buildResponse() failed!");
        }
    }

    @Test
    @DisplayName("Request type is \"distances\"")
    public void testType() {
        String type = conf.getRequestType();
        assertEquals("distances", type);
    }
    
    @Test
    @DisplayName("Places received")
    public void testPlaces() {
        Places places = conf.getPlaces();
        assertNotNull(places);
    }

    @Test
    @DisplayName("Earth radius received")
    public void testEarthRadius(){
        int earthRadius = conf.getEarthRadius(); //TODO: Maybe change units for radius
        assertEquals(-2, earthRadius); 
    }

    @Test
    @DisplayName("Distances received")
    public void testDistances() {
        ArrayList<Integer> distances = conf.getDistances();
        assertNotNull(distances);
    }
}
