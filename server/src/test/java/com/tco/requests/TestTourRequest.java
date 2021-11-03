package com.tco.requests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TestTourRequest {

    private TourRequest tour;

    @BeforeEach
    public void createConfigurationForTestCases() {
        tour = new TourRequest();
    }

    @Test
    @DisplayName("Request type is \"tour\"")
    public void testType() {
        assertEquals("tour", tour.getRequestType());
    }
}
