package com.tco.requests;

import com.tco.misc.BadRequestException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.jupiter.api.Assertions.*;

public class TestDistanceRequest {    
    private final transient Logger log = LoggerFactory.getLogger(TestConfigRequest.class);
    private DistanceRequest conf;

    @BeforeEach
    public void createConfigurationForTestCases() {
        conf = new DistanceRequest();
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
        Number earthRadius = conf.getEarthRadius(); //TODO: Maybe change units for radius
        assertEquals(-2.000000, earthRadius); 
    }

    @Test
    @DisplayName("Distances received")
    public void testDistances() {
        Distances distances = conf.getDistances();
        assertNotNull(distances);
    }
}
