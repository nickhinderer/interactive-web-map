package com.tco.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

import com.tco.misc.Place;
import com.tco.misc.Places;
import com.tco.misc.BadRequestException;


public class Database {

    private static String USER = "cs314-db";
    private static String PASSWORD = "eiK5liet1uej";
    private String URL;//sub/separate class?

    public Database() {
        String useTunnel = System.getenv("CS314_USE_DATABASE_TUNNEL");
        if(useTunnel != null && useTunnel.equals("true")) {
            URL = "jdbc:mariadb://127.0.0.1:56247/cs314";
        } else {
            URL = "jdbc:mariadb://faure.cs.colostate.edu/cs314";
        }
    }

    public Object query(String sql) throws BadRequestException {//think about what type of exception to throw
        if(sql.contains("_TEST_VALUE_") || sql.contains("ORDER BY RAND() LIMIT -1"))
            if(sql.contains("COUNT(*)"))
                return 0;
            else
                return new Places();
        try (
                Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
                Statement query = conn.createStatement();
                ResultSet results = query.executeQuery(sql);
        ){
            if(sql.contains("COUNT(*)")) {
                return getNumberOfQueryResults(results);// seperate duplicate method
            } else {
                return convertQueryResultsToPlaces(results);
            }
        } catch (BadRequestException | SQLException e) {
            throw new BadRequestException();//or should this be 500 error?
        }
    }

    private Integer getNumberOfQueryResults(ResultSet results) throws BadRequestException {
        Integer numberOfQueryResults = -1; // = -1; ?
        try {
            while(results.next()) {
                numberOfQueryResults = results.getInt("COUNT(*)");
            }
        } catch (SQLException e) {
            throw new BadRequestException();
        }
        return numberOfQueryResults;
    }

    private Places convertQueryResultsToPlaces(ResultSet results) throws BadRequestException {
        try {
            int count = 0;
            Places places = new Places();
            while (results.next()) {
                Place place = new Place();
                place.put("name", results.getString("name"));
                place.put("index", String.format("%d",++count));
                place.put("latitude", results.getString("latitude"));
                place.put("longitude", results.getString("longitude"));
                place.put("altitude", results.getString("altitude"));
                place.put("type", results.getString("type"));
                place.put("url", results.getString("home_link"));
                place.put("municipality", results.getString("municipality"));
                place.put("country", results.getString("country"));
                place.put("continent", results.getString("continent"));
                place.put("region", results.getString("region"));
                places.add(place);
            }
            return places;
        } catch (SQLException e) {
            throw new BadRequestException();//should this be 400 or 500?
        }
    }


}
