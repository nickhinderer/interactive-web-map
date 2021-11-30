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
    @DisplayName("fourth test case succeeded")
    public void testOptimizeTourCase5() {
        Places case5 = new Places();
        Place place0 = new Place();
        place0.put("latitude", "12.396551");
        place0.put("longitude", "58.977234");

        Place place1 = new Place();
        place1.put("latitude", "73.950015");
        place1.put("longitude", "78.924435");

        Place place2 = new Place();
        place2.put("latitude", "20.27533");
        place2.put("longitude", "82.218138");

        Place place3 = new Place();
        place3.put("latitude", "49.216469");
        place3.put("longitude", "28.070283");

        Place place4 = new Place();
        place4.put("latitude", "39.504374");
        place4.put("longitude", "73.062942");

        Place place5 = new Place();
        place5.put("latitude", "20.721909");
        place5.put("longitude", "6.902326");

        Place place6 = new Place();
        place6.put("latitude", "50.771374");
        place6.put("longitude", "75.294857");

        Place place7 = new Place();
        place7.put("latitude", "8.553455");
        place7.put("longitude", "20.917302");

        Place place8 = new Place();
        place8.put("latitude", "17.799173");
        place8.put("longitude", "53.002051");

        Place place9 = new Place();
        place9.put("latitude", "35.522846");
        place9.put("longitude", "4.161539");

        Place place10 = new Place();
        place10.put("latitude", "72.153274");
        place10.put("longitude", "55.853584");

        Place place11 = new Place();
        place11.put("latitude", "17.919214");
        place11.put("longitude", "79.409721");

        Place place12 = new Place();
        place12.put("latitude", "32.860069");
        place12.put("longitude", "10.692299");

        Place place13 = new Place();
        place13.put("latitude", "87.200165");
        place13.put("longitude", "84.568532");

        Place place14 = new Place();
        place14.put("latitude", "13.089355");
        place14.put("longitude", "25.586993");

        Place place15 = new Place();
        place15.put("latitude", "75.444259");
        place15.put("longitude", "41.346253");

        Place place16 = new Place();
        place16.put("latitude", "81.095115");
        place16.put("longitude", "1.473926");

        Place place17 = new Place();
        place17.put("latitude", "49.184952");
        place17.put("longitude", "16.405196");

        Place place18 = new Place();
        place18.put("latitude", "47.35083");
        place18.put("longitude", "76.834222");

        Place place19 = new Place();
        place19.put("latitude", "16.411393");
        place19.put("longitude", "41.597281");

        Place place20 = new Place();
        place20.put("latitude", "4.718924");
        place20.put("longitude", "42.275507");

        Place place21 = new Place();
        place21.put("latitude", "6.812075");
        place21.put("longitude", "77.605228");

        Place place22 = new Place();
        place22.put("latitude", "75.849855");
        place22.put("longitude", "85.988023");

        Place place23 = new Place();
        place23.put("latitude", "3.248633");
        place23.put("longitude", "39.859358");

        Place place24 = new Place();
        place24.put("latitude", "61.103063");
        place24.put("longitude", "50.778391");

        Place place25 = new Place();
        place25.put("latitude", "57.346782");
        place25.put("longitude", "73.938615");

        Place place26 = new Place();
        place26.put("latitude", "48.760925");
        place26.put("longitude", "17.307245");

        Place place27 = new Place();
        place27.put("latitude", "18.326711");
        place27.put("longitude", "89.847857");

        Place place28 = new Place();
        place28.put("latitude", "56.799227");
        place28.put("longitude", "37.808699");

        Place place29 = new Place();
        place29.put("latitude", "81.096633");
        place29.put("longitude", "86.798788");

        Place place30 = new Place();
        place30.put("latitude", "17.155355");
        place30.put("longitude", "71.76933");

        Place place31 = new Place();
        place31.put("latitude", "6.715165");
        place31.put("longitude", "45.529085");

        Place place32 = new Place();
        place32.put("latitude", "42.07598");
        place32.put("longitude", "63.319673");

        Place place33 = new Place();
        place33.put("latitude", "31.200651");
        place33.put("longitude", "65.493132");

        Place place34 = new Place();
        place34.put("latitude", "69.134748");
        place34.put("longitude", "17.854384");

        Place place35 = new Place();
        place35.put("latitude", "56.454551");
        place35.put("longitude", "5.63791");

        Place place36 = new Place();
        place36.put("latitude", "41.944466");
        place36.put("longitude", "9.379444");

        Place place37 = new Place();
        place37.put("latitude", "72.337118");
        place37.put("longitude", "87.922647");

        Place place38 = new Place();
        place38.put("latitude", "15.630077");
        place38.put("longitude", "42.256149");

        Place place39 = new Place();
        place39.put("latitude", "70.315664");
        place39.put("longitude", "53.551049");

        Place place40 = new Place();
        place40.put("latitude", "6.507134");
        place40.put("longitude", "11.782032");

        Place place41 = new Place();
        place41.put("latitude", "48.529476");
        place41.put("longitude", "0.1565");

        Place place42 = new Place();
        place42.put("latitude", "8.725333");
        place42.put("longitude", "18.31315");

        Place place43 = new Place();
        place43.put("latitude", "78.359853");
        place43.put("longitude", "40.464292");

        Place place44 = new Place();
        place44.put("latitude", "25.630931");
        place44.put("longitude", "49.742288");

        Place place45 = new Place();
        place45.put("latitude", "35.791447");
        place45.put("longitude", "79.732427");

        Place place46 = new Place();
        place46.put("latitude", "57.775003");
        place46.put("longitude", "40.164929");

        Place place47 = new Place();
        place47.put("latitude", "15.77859");
        place47.put("longitude", "67.621366");

        Place place48 = new Place();
        place48.put("latitude", "61.663366");
        place48.put("longitude", "89.155929");

        Place place49 = new Place();
        place49.put("latitude", "32.842163");
        place49.put("longitude", "45.759398");

        Place place50 = new Place();
        place50.put("latitude", "39.362442");
        place50.put("longitude", "24.130129");

        Place place51 = new Place();
        place51.put("latitude", "30.279143");
        place51.put("longitude", "76.697138");

        Place place52 = new Place();
        place52.put("latitude", "42.450033");
        place52.put("longitude", "26.135405");

        Place place53 = new Place();
        place53.put("latitude", "12.51879");
        place53.put("longitude", "9.361456");

        Place place54 = new Place();
        place54.put("latitude", "10.643903");
        place54.put("longitude", "88.623959");

        Place place55 = new Place();
        place55.put("latitude", "89.389666");
        place55.put("longitude", "62.874083");

        Place place56 = new Place();
        place56.put("latitude", "34.073853");
        place56.put("longitude", "71.607422");

        Place place57 = new Place();
        place57.put("latitude", "17.225218");
        place57.put("longitude", "44.113416");

        Place place58 = new Place();
        place58.put("latitude", "40.275685");
        place58.put("longitude", "52.372055");

        Place place59 = new Place();
        place59.put("latitude", "55.844656");
        place59.put("longitude", "66.392516");

        Place place60 = new Place();
        place60.put("latitude", "23.702995");
        place60.put("longitude", "38.071615");

        Place place61 = new Place();
        place61.put("latitude", "79.660016");
        place61.put("longitude", "48.652203");

        Place place62 = new Place();
        place62.put("latitude", "52.64062");
        place62.put("longitude", "4.161717");

        Place place63 = new Place();
        place63.put("latitude", "2.834511");
        place63.put("longitude", "30.44883");

        Place place64 = new Place();
        place64.put("latitude", "15.205584");
        place64.put("longitude", "44.054619");

        Place place65 = new Place();
        place65.put("latitude", "11.172963");
        place65.put("longitude", "11.039271");

        Place place66 = new Place();
        place66.put("latitude", "18.631053");
        place66.put("longitude", "80.560141");

        Place place67 = new Place();
        place67.put("latitude", "27.425039");
        place67.put("longitude", "68.922031");

        Place place68 = new Place();
        place68.put("latitude", "70.686335");
        place68.put("longitude", "81.854514");

        Place place69 = new Place();
        place69.put("latitude", "31.962702");
        place69.put("longitude", "47.8891");

        Place place70 = new Place();
        place70.put("latitude", "7.172103");
        place70.put("longitude", "52.487478");

        Place place71 = new Place();
        place71.put("latitude", "67.588768");
        place71.put("longitude", "10.093113");

        Place place72 = new Place();
        place72.put("latitude", "83.196041");
        place72.put("longitude", "52.493102");

        Place place73 = new Place();
        place73.put("latitude", "41.388557");
        place73.put("longitude", "87.194174");

        Place place74 = new Place();
        place74.put("latitude", "47.835588");
        place74.put("longitude", "34.014169");

        Place place75 = new Place();
        place75.put("latitude", "72.522427");
        place75.put("longitude", "20.990685");

        Place place76 = new Place();
        place76.put("latitude", "27.518665");
        place76.put("longitude", "54.425894");

        Place place77 = new Place();
        place77.put("latitude", "8.921601");
        place77.put("longitude", "43.497212");

        Place place78 = new Place();
        place78.put("latitude", "80.92929");
        place78.put("longitude", "3.108405");

        Place place79 = new Place();
        place79.put("latitude", "77.687869");
        place79.put("longitude", "25.072905");

        Place place80 = new Place();
        place80.put("latitude", "11.316759");
        place80.put("longitude", "37.130243");

        Place place81 = new Place();
        place81.put("latitude", "87.908796");
        place81.put("longitude", "35.304679");

        Place place82 = new Place();
        place82.put("latitude", "32.744598");
        place82.put("longitude", "42.978156");

        Place place83 = new Place();
        place83.put("latitude", "41.441539");
        place83.put("longitude", "42.035697");

        Place place84 = new Place();
        place84.put("latitude", "79.886194");
        place84.put("longitude", "65.19966");

        Place place85 = new Place();
        place85.put("latitude", "5.345536");
        place85.put("longitude", "66.728973");

        Place place86 = new Place();
        place86.put("latitude", "45.939473");
        place86.put("longitude", "3.140703");

        Place place87 = new Place();
        place87.put("latitude", "49.421035");
        place87.put("longitude", "35.042261");

        Place place88 = new Place();
        place88.put("latitude", "80.540198");
        place88.put("longitude", "72.295023");

        Place place89 = new Place();
        place89.put("latitude", "84.311368");
        place89.put("longitude", "7.125397");

        Place place90 = new Place();
        place90.put("latitude", "61.114039");
        place90.put("longitude", "39.358703");

        Place place91 = new Place();
        place91.put("latitude", "60.256642");
        place91.put("longitude", "46.017377");

        Place place92 = new Place();
        place92.put("latitude", "2.266473");
        place92.put("longitude", "19.567203");

        Place place93 = new Place();
        place93.put("latitude", "80.24978");
        place93.put("longitude", "87.572953");

        Place place94 = new Place();
        place94.put("latitude", "89.013886");
        place94.put("longitude", "42.27376");

        Place place95 = new Place();
        place95.put("latitude", "45.881946");
        place95.put("longitude", "28.901496");

        Place place96 = new Place();
        place96.put("latitude", "46.89905");
        place96.put("longitude", "44.638149");

        Place place97 = new Place();
        place97.put("latitude", "13.6624");
        place97.put("longitude", "38.560606");

        Place place98 = new Place();
        place98.put("latitude", "49.391147");
        place98.put("longitude", "48.292029");

        Place place99 = new Place();
        place99.put("latitude", "39.54984");
        place99.put("longitude", "36.071483");

        case5.add(place0);
        case5.add(place1);
        case5.add(place2);
        case5.add(place3);
        case5.add(place4);
        case5.add(place5);
        case5.add(place6);
        case5.add(place7);
        case5.add(place8);
        case5.add(place9);
        case5.add(place10);
        case5.add(place11);
        case5.add(place12);
        case5.add(place13);
        case5.add(place14);
        case5.add(place15);
        case5.add(place16);
        case5.add(place17);
        case5.add(place18);
        case5.add(place19);
        case5.add(place20);
        case5.add(place21);
        case5.add(place22);
        case5.add(place23);
        case5.add(place24);
        case5.add(place25);
        case5.add(place26);
        case5.add(place27);
        case5.add(place28);
        case5.add(place29);
        case5.add(place30);
        case5.add(place31);
        case5.add(place32);
        case5.add(place33);
        case5.add(place34);
        case5.add(place35);
        case5.add(place36);
        case5.add(place37);
        case5.add(place38);
        case5.add(place39);
        case5.add(place40);
        case5.add(place41);
        case5.add(place42);
        case5.add(place43);
        case5.add(place44);
        case5.add(place45);
        case5.add(place46);
        case5.add(place47);
        case5.add(place48);
        case5.add(place49);
        case5.add(place50);
        case5.add(place51);
        case5.add(place52);
        case5.add(place53);
        case5.add(place54);
        case5.add(place55);
        case5.add(place56);
        case5.add(place57);
        case5.add(place58);
        case5.add(place59);
        case5.add(place60);
        case5.add(place61);
        case5.add(place62);
        case5.add(place63);
        case5.add(place64);
        case5.add(place65);
        case5.add(place66);
        case5.add(place67);
        case5.add(place68);
        case5.add(place69);
        case5.add(place70);
        case5.add(place71);
        case5.add(place72);
        case5.add(place73);
        case5.add(place74);
        case5.add(place75);
        case5.add(place76);
        case5.add(place77);
        case5.add(place78);
        case5.add(place79);
        case5.add(place80);
        case5.add(place81);
        case5.add(place82);
        case5.add(place83);
        case5.add(place84);
        case5.add(place85);
        case5.add(place86);
        case5.add(place87);
        case5.add(place88);
        case5.add(place89);
        case5.add(place90);
        case5.add(place91);
        case5.add(place92);
        case5.add(place93);
        case5.add(place94);
        case5.add(place95);
        case5.add(place96);
        case5.add(place97);
        case5.add(place98);
        case5.add(place99);
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
