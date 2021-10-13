package com.tco.misc;

import com.tco.misc.Distances;
import com.tco.misc.Places;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class TestDistances {

    @BeforeEach
    public void createConfigurationForTestCases() {
        Distances conf = new Distances(new Places(), 0);
        conf.computeDistances();
    }
}
