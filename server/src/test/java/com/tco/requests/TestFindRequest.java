package com.tco.requests;

import com.tco.misc.BadRequestException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestFindRequest {

    private FindRequest conf;

    @BeforeEach
    public void createConfigurationForTestCases() {
        conf = new FindRequest();
        try { //nick_ come back and handle in a better way
            conf.buildResponse();
        } catch (BadRequestException e) {

        }
    }

    @Test
    @DisplayName("Request type is \"find\"")
    public void testType() {
        String type = conf.getRequestType();
        assertEquals("find", type);
    }

    @Test
    @DisplayName("limit received")
    public void testLimit(){
        int limit = conf.getlimit();
        assertEquals(0, limit);
    }

    @Test
    @DisplayName("Match received")
    public void testMatch() {
        String match = conf.getMatch();
        assert match.length()>=0;
    }
}