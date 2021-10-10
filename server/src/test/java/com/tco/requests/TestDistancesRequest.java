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
        conf.buildResponse();
    }

    @Test
    @DisplayName("Request type is \"distances\"")
    public void testType() {
        assertEquals("distances", conf.getRequestType());
    }
    
    @Test
    @DisplayName("Places received")
    public void testPlaces() {
        assertNotNull(conf.getPlaces());
    }

    @Test
    @DisplayName("Earth radius received")
    public void testEarthRadius(){
        assertEquals(0, conf.getEarthRadius());
    }

    @Test
    @DisplayName("Distances received")
    public void testDistances() {
        assertNotNull(conf.getDistances());
    }
}
