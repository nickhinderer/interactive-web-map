package com.tco.misc;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

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
        Place[] placeArr = new Place[100];

        placeArr[0] = new Place();
        placeArr[0].put("latitude", "45.046333");
        placeArr[0].put("longitude", "17.468747");

        placeArr[1] = new Place();
        placeArr[1].put("latitude", "25.767409");
        placeArr[1].put("longitude", "42.602702");

        placeArr[2] = new Place();
        placeArr[2].put("latitude", "16.838649");
        placeArr[2].put("longitude", "50.403591");

        placeArr[3] = new Place();
        placeArr[3].put("latitude", "83.306177");
        placeArr[3].put("longitude", "48.917132");

        placeArr[4] = new Place();
        placeArr[4].put("latitude", "45.885267");
        placeArr[4].put("longitude", "6.722862");

        placeArr[5] = new Place();
        placeArr[5].put("latitude", "79.686651");
        placeArr[5].put("longitude", "43.661283");

        placeArr[6] = new Place();
        placeArr[6].put("latitude", "25.157554");
        placeArr[6].put("longitude", "37.30931");

        placeArr[7] = new Place();
        placeArr[7].put("latitude", "66.770892");
        placeArr[7].put("longitude", "82.988125");

        placeArr[8] = new Place();
        placeArr[8].put("latitude", "27.111899");
        placeArr[8].put("longitude", "30.647088");

        placeArr[9] = new Place();
        placeArr[9].put("latitude", "66.08594");
        placeArr[9].put("longitude", "6.435964");

        placeArr[10] = new Place();
        placeArr[10].put("latitude", "44.321511");
        placeArr[10].put("longitude", "36.265928");

        placeArr[11] = new Place();
        placeArr[11].put("latitude", "34.78082");
        placeArr[11].put("longitude", "28.14778");

        placeArr[12] = new Place();
        placeArr[12].put("latitude", "15.319564");
        placeArr[12].put("longitude", "36.609988");

        placeArr[13] = new Place();
        placeArr[13].put("latitude", "82.418822");
        placeArr[13].put("longitude", "66.852821");

        placeArr[14] = new Place();
        placeArr[14].put("latitude", "63.03285");
        placeArr[14].put("longitude", "10.123213");

        placeArr[15] = new Place();
        placeArr[15].put("latitude", "50.590168");
        placeArr[15].put("longitude", "49.011204");

        placeArr[16] = new Place();
        placeArr[16].put("latitude", "15.182159");
        placeArr[16].put("longitude", "54.618849");

        placeArr[17] = new Place();
        placeArr[17].put("latitude", "12.016493");
        placeArr[17].put("longitude", "1.064721");

        placeArr[18] = new Place();
        placeArr[18].put("latitude", "84.32543");
        placeArr[18].put("longitude", "51.774197");

        placeArr[19] = new Place();
        placeArr[19].put("latitude", "13.532683");
        placeArr[19].put("longitude", "33.637888");

        placeArr[20] = new Place();
        placeArr[20].put("latitude", "19.800494");
        placeArr[20].put("longitude", "78.147803");

        placeArr[21] = new Place();
        placeArr[21].put("latitude", "60.776592");
        placeArr[21].put("longitude", "8.117689");

        placeArr[22] = new Place();
        placeArr[22].put("latitude", "75.096749");
        placeArr[22].put("longitude", "8.528924");

        placeArr[23] = new Place();
        placeArr[23].put("latitude", "3.722064");
        placeArr[23].put("longitude", "66.939323");

        placeArr[24] = new Place();
        placeArr[24].put("latitude", "41.973895");
        placeArr[24].put("longitude", "73.368577");

        placeArr[25] = new Place();
        placeArr[25].put("latitude", "7.900924");
        placeArr[25].put("longitude", "69.871083");

        placeArr[26] = new Place();
        placeArr[26].put("latitude", "71.344329");
        placeArr[26].put("longitude", "14.670298");

        placeArr[27] = new Place();
        placeArr[27].put("latitude", "43.964861");
        placeArr[27].put("longitude", "55.490313");

        placeArr[28] = new Place();
        placeArr[28].put("latitude", "3.180456");
        placeArr[28].put("longitude", "5.548452");

        placeArr[29] = new Place();
        placeArr[29].put("latitude", "87.665449");
        placeArr[29].put("longitude", "77.853612");

        placeArr[30] = new Place();
        placeArr[30].put("latitude", "30.310107");
        placeArr[30].put("longitude", "53.707625");

        placeArr[31] = new Place();
        placeArr[31].put("latitude", "18.489351");
        placeArr[31].put("longitude", "88.876229");

        placeArr[32] = new Place();
        placeArr[32].put("latitude", "43.940242");
        placeArr[32].put("longitude", "31.116928");

        placeArr[33] = new Place();
        placeArr[33].put("latitude", "43.295011");
        placeArr[33].put("longitude", "46.64675");

        placeArr[34] = new Place();
        placeArr[34].put("latitude", "69.898087");
        placeArr[34].put("longitude", "76.47915");

        placeArr[35] = new Place();
        placeArr[35].put("latitude", "46.776306");
        placeArr[35].put("longitude", "51.753484");

        placeArr[36] = new Place();
        placeArr[36].put("latitude", "59.053346");
        placeArr[36].put("longitude", "22.791177");

        placeArr[37] = new Place();
        placeArr[37].put("latitude", "7.495702");
        placeArr[37].put("longitude", "70.960952");

        placeArr[38] = new Place();
        placeArr[38].put("latitude", "74.008916");
        placeArr[38].put("longitude", "3.790936");

        placeArr[39] = new Place();
        placeArr[39].put("latitude", "40.549915");
        placeArr[39].put("longitude", "18.05287");

        placeArr[40] = new Place();
        placeArr[40].put("latitude", "9.278382");
        placeArr[40].put("longitude", "26.334186");

        placeArr[41] = new Place();
        placeArr[41].put("latitude", "13.384286");
        placeArr[41].put("longitude", "38.787263");

        placeArr[42] = new Place();
        placeArr[42].put("latitude", "49.847376");
        placeArr[42].put("longitude", "27.9305");

        placeArr[43] = new Place();
        placeArr[43].put("latitude", "84.104884");
        placeArr[43].put("longitude", "68.027393");

        placeArr[44] = new Place();
        placeArr[44].put("latitude", "16.478871");
        placeArr[44].put("longitude", "21.919314");

        placeArr[45] = new Place();
        placeArr[45].put("latitude", "7.877129");
        placeArr[45].put("longitude", "6.697516");

        placeArr[46] = new Place();
        placeArr[46].put("latitude", "12.252519");
        placeArr[46].put("longitude", "84.448522");

        placeArr[47] = new Place();
        placeArr[47].put("latitude", "71.531579");
        placeArr[47].put("longitude", "13.262196");

        placeArr[48] = new Place();
        placeArr[48].put("latitude", "41.510618");
        placeArr[48].put("longitude", "69.187727");

        placeArr[49] = new Place();
        placeArr[49].put("latitude", "74.247552");
        placeArr[49].put("longitude", "24.576456");

        placeArr[50] = new Place();
        placeArr[50].put("latitude", "66.541938");
        placeArr[50].put("longitude", "57.102417");

        placeArr[51] = new Place();
        placeArr[51].put("latitude", "9.247722");
        placeArr[51].put("longitude", "0.217574");

        placeArr[52] = new Place();
        placeArr[52].put("latitude", "64.866472");
        placeArr[52].put("longitude", "53.289254");

        placeArr[53] = new Place();
        placeArr[53].put("latitude", "56.206121");
        placeArr[53].put("longitude", "54.716744");

        placeArr[54] = new Place();
        placeArr[54].put("latitude", "7.304835");
        placeArr[54].put("longitude", "36.087148");

        placeArr[55] = new Place();
        placeArr[55].put("latitude", "75.151189");
        placeArr[55].put("longitude", "46.051441");

        placeArr[56] = new Place();
        placeArr[56].put("latitude", "56.387565");
        placeArr[56].put("longitude", "50.370318");

        placeArr[57] = new Place();
        placeArr[57].put("latitude", "50.500536");
        placeArr[57].put("longitude", "32.368541");

        placeArr[58] = new Place();
        placeArr[58].put("latitude", "39.076314");
        placeArr[58].put("longitude", "85.087765");

        placeArr[59] = new Place();
        placeArr[59].put("latitude", "77.163713");
        placeArr[59].put("longitude", "67.075207");

        placeArr[60] = new Place();
        placeArr[60].put("latitude", "26.109505");
        placeArr[60].put("longitude", "89.287977");

        placeArr[61] = new Place();
        placeArr[61].put("latitude", "4.140946");
        placeArr[61].put("longitude", "78.359245");

        placeArr[62] = new Place();
        placeArr[62].put("latitude", "69.34464");
        placeArr[62].put("longitude", "77.648278");

        placeArr[63] = new Place();
        placeArr[63].put("latitude", "21.194132");
        placeArr[63].put("longitude", "86.971614");

        placeArr[64] = new Place();
        placeArr[64].put("latitude", "3.552155");
        placeArr[64].put("longitude", "45.348515");

        placeArr[65] = new Place();
        placeArr[65].put("latitude", "47.653385");
        placeArr[65].put("longitude", "67.386868");

        placeArr[66] = new Place();
        placeArr[66].put("latitude", "25.791342");
        placeArr[66].put("longitude", "77.793328");

        placeArr[67] = new Place();
        placeArr[67].put("latitude", "62.165074");
        placeArr[67].put("longitude", "79.977732");

        placeArr[68] = new Place();
        placeArr[68].put("latitude", "47.691956");
        placeArr[68].put("longitude", "18.384412");

        placeArr[69] = new Place();
        placeArr[69].put("latitude", "16.874252");
        placeArr[69].put("longitude", "27.364868");

        placeArr[70] = new Place();
        placeArr[70].put("latitude", "47.001606");
        placeArr[70].put("longitude", "9.661247");

        placeArr[71] = new Place();
        placeArr[71].put("latitude", "57.181686");
        placeArr[71].put("longitude", "72.109622");

        placeArr[72] = new Place();
        placeArr[72].put("latitude", "22.384461");
        placeArr[72].put("longitude", "40.892839");

        placeArr[73] = new Place();
        placeArr[73].put("latitude", "81.097712");
        placeArr[73].put("longitude", "45.800738");

        placeArr[74] = new Place();
        placeArr[74].put("latitude", "8.637265");
        placeArr[74].put("longitude", "86.389382");

        placeArr[75] = new Place();
        placeArr[75].put("latitude", "12.499716");
        placeArr[75].put("longitude", "44.879424");

        placeArr[76] = new Place();
        placeArr[76].put("latitude", "48.633424");
        placeArr[76].put("longitude", "88.457878");

        placeArr[77] = new Place();
        placeArr[77].put("latitude", "31.431471");
        placeArr[77].put("longitude", "23.221402");

        placeArr[78] = new Place();
        placeArr[78].put("latitude", "65.601693");
        placeArr[78].put("longitude", "61.9629");

        placeArr[79] = new Place();
        placeArr[79].put("latitude", "87.350356");
        placeArr[79].put("longitude", "12.570338");

        placeArr[80] = new Place();
        placeArr[80].put("latitude", "86.263335");
        placeArr[80].put("longitude", "17.633863");

        placeArr[81] = new Place();
        placeArr[81].put("latitude", "37.734175");
        placeArr[81].put("longitude", "1.99177");

        placeArr[82] = new Place();
        placeArr[82].put("latitude", "54.17788");
        placeArr[82].put("longitude", "80.53734");

        placeArr[83] = new Place();
        placeArr[83].put("latitude", "22.945745");
        placeArr[83].put("longitude", "10.5546");

        placeArr[84] = new Place();
        placeArr[84].put("latitude", "10.662848");
        placeArr[84].put("longitude", "71.06894");

        placeArr[85] = new Place();
        placeArr[85].put("latitude", "66.047602");
        placeArr[85].put("longitude", "75.511605");

        placeArr[86] = new Place();
        placeArr[86].put("latitude", "20.253485");
        placeArr[86].put("longitude", "52.94177");

        placeArr[87] = new Place();
        placeArr[87].put("latitude", "75.642605");
        placeArr[87].put("longitude", "15.002414");

        placeArr[88] = new Place();
        placeArr[88].put("latitude", "72.801827");
        placeArr[88].put("longitude", "27.897445");

        placeArr[89] = new Place();
        placeArr[89].put("latitude", "59.355774");
        placeArr[89].put("longitude", "6.672899");

        placeArr[90] = new Place();
        placeArr[90].put("latitude", "73.853122");
        placeArr[90].put("longitude", "71.101273");

        placeArr[91] = new Place();
        placeArr[91].put("latitude", "7.095625");
        placeArr[91].put("longitude", "13.510319");

        placeArr[92] = new Place();
        placeArr[92].put("latitude", "53.204066");
        placeArr[92].put("longitude", "50.968835");

        placeArr[93] = new Place();
        placeArr[93].put("latitude", "83.104954");
        placeArr[93].put("longitude", "56.46325");

        placeArr[94] = new Place();
        placeArr[94].put("latitude", "24.512615");
        placeArr[94].put("longitude", "16.478091");

        placeArr[95] = new Place();
        placeArr[95].put("latitude", "50.462307");
        placeArr[95].put("longitude", "16.701406");

        placeArr[96] = new Place();
        placeArr[96].put("latitude", "28.698354");
        placeArr[96].put("longitude", "9.484357");

        placeArr[97] = new Place();
        placeArr[97].put("latitude", "70.531188");
        placeArr[97].put("longitude", "69.309897");

        placeArr[98] = new Place();
        placeArr[98].put("latitude", "16.744732");
        placeArr[98].put("longitude", "56.876322");

        placeArr[99] = new Place();
        placeArr[99].put("latitude", "83.817508");
        placeArr[99].put("longitude", "10.77347");


        case5.addAll(Arrays.asList(placeArr).subList(0, 100));

        tour.setPlaces(case5);
        tour.setInstanceVariables();
        tour.optimizeTour();

        assertEquals(41952L, tour.getTourDistance());
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
