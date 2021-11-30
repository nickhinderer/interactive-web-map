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
        assertEquals(0.6, tour.getResponse());
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
    @DisplayName("fourth test case succeeded")
    public void testOptimizeTourCase4() {
        Places case4 = new Places();

        Place place0 = new Place();
        place0.put("latitude", "73.483393");
        place0.put("longitude", "57.441926");

        Place place1 = new Place();
        place1.put("latitude", "0.914055");
        place1.put("longitude", "15.279446");

        Place place2 = new Place();
        place2.put("latitude", "60.07272");
        place2.put("longitude", "84.57506");

        Place place3 = new Place();
        place3.put("latitude", "22.293991");
        place3.put("longitude", "12.357992");

        Place place4 = new Place();
        place4.put("latitude", "87.109542");
        place4.put("longitude", "60.707786");

        Place place5 = new Place();
        place5.put("latitude", "55.959969");
        place5.put("longitude", "9.841287");

        Place place6 = new Place();
        place6.put("latitude", "5.437004");
        place6.put("longitude", "10.917479");

        Place place7 = new Place();
        place7.put("latitude", "78.781366");
        place7.put("longitude", "85.231149");

        Place place8 = new Place();
        place8.put("latitude", "24.83434");
        place8.put("longitude", "86.6069");

        Place place9 = new Place();
        place9.put("latitude", "40.442382");
        place9.put("longitude", "14.77605");

        Place place10 = new Place();
        place10.put("latitude", "14.647753");
        place10.put("longitude", "4.482893");

        Place place11 = new Place();
        place11.put("latitude", "79.05465");
        place11.put("longitude", "59.852437");

        Place place12 = new Place();
        place12.put("latitude", "28.606599");
        place12.put("longitude", "6.680286");

        Place place13 = new Place();
        place13.put("latitude", "29.914527");
        place13.put("longitude", "25.554179");

        Place place14 = new Place();
        place14.put("latitude", "45.799021");
        place14.put("longitude", "20.845682");

        Place place15 = new Place();
        place15.put("latitude", "39.661124");
        place15.put("longitude", "71.059425");

        Place place16 = new Place();
        place16.put("latitude", "36.343679");
        place16.put("longitude", "19.310857");

        Place place17 = new Place();
        place17.put("latitude", "47.012861");
        place17.put("longitude", "44.540087");

        Place place18 = new Place();
        place18.put("latitude", "86.449258");
        place18.put("longitude", "85.685025");

        Place place19 = new Place();
        place19.put("latitude", "24.964983");
        place19.put("longitude", "7.732225");

        Place place20 = new Place();
        place20.put("latitude", "42.125562");
        place20.put("longitude", "33.272567");

        Place place21 = new Place();
        place21.put("latitude", "71.927962");
        place21.put("longitude", "83.002177");

        Place place22 = new Place();
        place22.put("latitude", "53.919079");
        place22.put("longitude", "62.613562");

        Place place23 = new Place();
        place23.put("latitude", "71.329667");
        place23.put("longitude", "34.227874");

        Place place24 = new Place();
        place24.put("latitude", "28.465427");
        place24.put("longitude", "45.431642");

        Place place25 = new Place();
        place25.put("latitude", "15.027118");
        place25.put("longitude", "70.666583");

        Place place26 = new Place();
        place26.put("latitude", "68.818665");
        place26.put("longitude", "2.431937");

        Place place27 = new Place();
        place27.put("latitude", "66.116288");
        place27.put("longitude", "4.792276");

        Place place28 = new Place();
        place28.put("latitude", "14.419234");
        place28.put("longitude", "68.346486");

        Place place29 = new Place();
        place29.put("latitude", "31.894939");
        place29.put("longitude", "10.997606");

        Place place30 = new Place();
        place30.put("latitude", "86.723139");
        place30.put("longitude", "56.843704");

        Place place31 = new Place();
        place31.put("latitude", "62.278895");
        place31.put("longitude", "4.162525");

        Place place32 = new Place();
        place32.put("latitude", "81.042435");
        place32.put("longitude", "51.435783");

        Place place33 = new Place();
        place33.put("latitude", "87.898281");
        place33.put("longitude", "8.352078");

        Place place34 = new Place();
        place34.put("latitude", "68.535748");
        place34.put("longitude", "9.765359");

        Place place35 = new Place();
        place35.put("latitude", "19.284537");
        place35.put("longitude", "6.47816");

        Place place36 = new Place();
        place36.put("latitude", "50.152577");
        place36.put("longitude", "61.229562");

        Place place37 = new Place();
        place37.put("latitude", "46.676821");
        place37.put("longitude", "1.364997");

        Place place38 = new Place();
        place38.put("latitude", "85.624954");
        place38.put("longitude", "68.714658");

        Place place39 = new Place();
        place39.put("latitude", "33.543299");
        place39.put("longitude", "31.07723");

        Place place40 = new Place();
        place40.put("latitude", "86.772934");
        place40.put("longitude", "33.61163");

        Place place41 = new Place();
        place41.put("latitude", "7.084795");
        place41.put("longitude", "73.662968");

        Place place42 = new Place();
        place42.put("latitude", "49.625647");
        place42.put("longitude", "21.481923");

        Place place43 = new Place();
        place43.put("latitude", "69.679488");
        place43.put("longitude", "77.936413");

        Place place44 = new Place();
        place44.put("latitude", "12.295168");
        place44.put("longitude", "66.797088");

        Place place45 = new Place();
        place45.put("latitude", "33.206026");
        place45.put("longitude", "71.308023");

        Place place46 = new Place();
        place46.put("latitude", "38.55351");
        place46.put("longitude", "21.179505");

        Place place47 = new Place();
        place47.put("latitude", "46.939667");
        place47.put("longitude", "47.234375");

        Place place48 = new Place();
        place48.put("latitude", "69.485311");
        place48.put("longitude", "21.546033");

        Place place49 = new Place();
        place49.put("latitude", "75.447185");
        place49.put("longitude", "34.4142");

        case4.add(place0);
        case4.add(place1);
        case4.add(place2);
        case4.add(place3);
        case4.add(place4);
        case4.add(place5);
        case4.add(place6);
        case4.add(place7);
        case4.add(place8);
        case4.add(place9);
        case4.add(place10);
        case4.add(place11);
        case4.add(place12);
        case4.add(place13);
        case4.add(place14);
        case4.add(place15);
        case4.add(place16);
        case4.add(place17);
        case4.add(place18);
        case4.add(place19);
        case4.add(place20);
        case4.add(place21);
        case4.add(place22);
        case4.add(place23);
        case4.add(place24);
        case4.add(place25);
        case4.add(place26);
        case4.add(place27);
        case4.add(place28);
        case4.add(place29);
        case4.add(place30);
        case4.add(place31);
        case4.add(place32);
        case4.add(place33);
        case4.add(place34);
        case4.add(place35);
        case4.add(place36);
        case4.add(place37);
        case4.add(place38);
        case4.add(place39);
        case4.add(place40);
        case4.add(place41);
        case4.add(place42);
        case4.add(place43);
        case4.add(place44);
        case4.add(place45);
        case4.add(place46);
        case4.add(place47);
        case4.add(place48);
        case4.add(place49);

        tour.setPlaces(case4);
        tour.setInstanceVariables();
        tour.optimizeTour();

        assertEquals(28691L, tour.getTourDistance());
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
