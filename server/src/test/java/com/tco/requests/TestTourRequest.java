package com.tco.requests;

import com.tco.misc.BadRequestException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TestTourRequest {

    private TourRequest tour;

    @BeforeEach
    public void createConfigurationForTestCases() {
        tour = new TourRequest();
        tour.buildResponse();
    }

    @Test
    @DisplayName("Request type is \"tour\"")
    public void testType() {
        assertEquals("tour", tour.getRequestType());
    }

    @Test
    @DisplayName("earthRadius is correct")
    public void testEarthRadius() {
        assertEquals(-1.0, tour.getEarthRadius());
    }

    @Test
    @DisplayName("response is correct")
    public void testResponse() {
        assertEquals(-1.0, tour.getResponse());
    }

}
