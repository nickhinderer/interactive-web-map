package com.tco.requests;

import com.tco.misc.BadRequestException;
import com.tco.misc.Places;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.jupiter.api.Assertions.*;

public class TestFindRequest {
    private final transient Logger log = LoggerFactory.getLogger(TestConfigRequest.class);
    private FindRequest conf;

    @BeforeEach
    public void createConfigurationForTestCases() {
        conf = new FindRequest();
        try { //nick_ come back and handle in a better way //log it. log
            conf.buildResponse();
        } catch (BadRequestException e) {
            log.error("buildResponse() failed!");
        }
    }

    @Test
    @DisplayName("Request type is \"find\"")
    public void testType() {
        String type = conf.getRequestType();
        assertEquals("find", type);
    }

    @Test
    @DisplayName("Limit received")
    public void testLimit(){
        int limit = conf.getLimit();
        assertEquals(-2, limit);
    }

    @Test
    @DisplayName("Match received")
    public void testMatch() {
        String match = conf.getMatch();
        assertNotNull(match);
    }

    @Test
    @DisplayName("Found received")
    public void testFound() {
        Integer found = conf.getFound();
        assertEquals(0, found);
    }

    @Test
    @DisplayName("Places received")
    public void testPlaces() {
        Places places = conf.getPlaces();
        assertNotNull(places);
    }
}