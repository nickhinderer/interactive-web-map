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
        assertEquals(0.2, tour.getResponse());
    }

    @Test
    @DisplayName("first test case succeeded")
    public void testOptimizeTourCase1() {
        Places case1 = new Places();

        Place place1 = new Place();
        place1.put("latitude", "47.90596");
        place1.put("longitude", "-89.90065");

        Place place2 = new Place();
        place2.put("latitude", "47.6679");
        place2.put("longitude", "-88.96132");

        Place place3 = new Place();
        place3.put("latitude", "47.37053");
        place3.put("longitude", "-88.95196");

        Place place4 = new Place();
        place4.put("latitude", "47.28676");
        place4.put("longitude", "-89.89403");

        Place place5 = new Place();
        place5.put("latitude", "47.3947");
        place5.put("longitude", "-90.45571");

        Place place6 = new Place();
        place6.put("latitude", "47.66916");
        place6.put("longitude", "-90.43648");

        case1.add(place1);
        case1.add(place3);
        case1.add(place6);
        case1.add(place5);
        case1.add(place2);
        case1.add(place4);

        tour.setPlaces(case1);
        tour.setInstanceVariables();
        tour.optimizeTour();

        assertEquals(188L, tour.getTourDistance());
    }

    @Test
    @DisplayName("second test case succeeded")
    public void testOptimizeTourCase2() {
        Places case2 = new Places();

        Place place1 = new Place();
        place1.put("latitude", "59.89277");
        place1.put("longitude", "-102.85546");

        Place place2 = new Place();
        place2.put("latitude", "51.73176");
        place2.put("longitude", "-177.03515");

        Place place3 = new Place();
        place3.put("latitude", "-5.60837");
        place3.put("longitude", "179.27344");

        Place place4 = new Place();
        place4.put("latitude", "-47.36484");
        place4.put("longitude", "-91.78124");

        Place place5 = new Place();
        place5.put("latitude", "-0.30207");
        place5.put("longitude", "9.11719");

        Place place6 = new Place();
        place6.put("latitude", "52.72634");
        place6.put("longitude", "7.71094");

        case2.add(place1);
        case2.add(place3);
        case2.add(place6);
        case2.add(place5);
        case2.add(place2);
        case2.add(place4);

        tour.setPlaces(case2);
        tour.setInstanceVariables();
        tour.optimizeTour();

        assertEquals(26766L, tour.getTourDistance());
    }

    @Test
    @DisplayName("third test case succeeded")
    public void testOptimizeTourCase3() {
        Places case3 = new Places();

        Place place1 = new Place();
        place1.put("latitude", "46.09126");
        place1.put("longitude", "-123.22489");

        Place place2 = new Place();
        place2.put("latitude", "42.63692");
        place2.put("longitude", "-123.31278");

        Place place3 = new Place();
        place3.put("latitude", "39.18429");
        place3.put("longitude", "-121.99442");
        Place place4 = new Place();
        place4.put("latitude", "35.41024");
        place4.put("longitude", "-119.62137");

        Place place5 = new Place();
        place5.put("latitude", "31.37583");
        place5.put("longitude", "-115.75419");

        Place place6 = new Place();
        place6.put("latitude", "27.31679");
        place6.put("longitude", "-113.20536");

        Place place7 = new Place();
        place7.put("latitude", "23.50724");
        place7.put("longitude", "-110.04129");

        Place place8 = new Place();
        place8.put("latitude", "17.75252");
        place8.put("longitude", "-99.75809");

        Place place9 = new Place();
        place9.put("latitude", "21.14974");
        place9.put("longitude", "-87.98075");

        Place place10 = new Place();
        place10.put("latitude", "25.90238");
        place10.put("longitude", "-80.86161");

        //random ordering
        case3.add(place1);
        case3.add(place9);
        case3.add(place2);
        case3.add(place6);
        case3.add(place10);
        case3.add(place7);
        case3.add(place3);
        case3.add(place5);
        case3.add(place4);
        case3.add(place8);

        tour.setPlaces(case3);
        tour.setInstanceVariables();
        tour.optimizeTour();

        assertEquals(6623L, tour.getTourDistance());

    }

    @Test
    @DisplayName("constructor works correctly")
    public void testTourConstructor() {
        Tour constructorTest = new Tour(new Places(), 0.0, 0.0);
        assertNotNull(constructorTest);
        assertEquals(new Places(), constructorTest.getPlaces());
        assertEquals(0.0, constructorTest.getEarthRadius());
        assertEquals(0.0, constructorTest.getResponse());
    }

}
