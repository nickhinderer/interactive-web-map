package com.tco.misc;

import com.tco.misc.Distances;
import com.tco.misc.Places;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class TestDistances {

    private Distances conf;

    @BeforeEach
    public void createConfigurationForTestCases() {
        conf = new Distances();
        conf.computeDistances();
    }
}
