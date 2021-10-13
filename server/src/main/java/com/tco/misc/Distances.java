package com.tco.misc;

import java.util.ArrayList;
import java.util.HashMap;
import java.lang.Math;

public class Distances {
    private Places places;
    private ArrayList<Integer> distances;
    private Integer earthRadius;

    public Distances(Places places, Integer earthRadius) { //no default constructor.
        this.places = places;
        this.earthRadius = earthRadius;
        this.distances = new ArrayList<>();
    }

    private double computeCentralAngle(HashMap<String, Double> coordinates) {
        double latitude1 = coordinates.get("latitude1");
        double latitude2 = coordinates.get("latitude2");
        double longitudeDifference = Math.abs(coordinates.get("longitude1") - coordinates.get("longitude2"));
        double cosineLatitude1 = Math.cos(Math.toRadians(latitude1));
        double cosineLatitude2 = Math.cos(Math.toRadians(latitude2));
        double sineLatitude1 = Math.sin(Math.toRadians(latitude1));
        double sineLatitude2 = Math.sin(Math.toRadians(latitude2));
        double cosineLongitudeDifference = Math.cos(Math.toRadians(longitudeDifference));
        double sineLongitudeDifference = Math.sin(Math.toRadians(longitudeDifference));


        double a = Math.sqrt(
                Math.pow((cosineLatitude2 * sineLongitudeDifference), 2) + Math.pow((cosineLatitude1 * sineLatitude2 - sineLatitude1 * cosineLatitude2 * cosineLongitudeDifference), 2)
        ) ;
        double b = (sineLatitude1 * sineLatitude2) + (cosineLatitude1 * cosineLatitude2 * cosineLongitudeDifference);
        return Math.atan2(a, b);
    }

    public ArrayList<Integer> computeDistances() {
        int n = this.places.size();
        for(int i = 1; i < n; i++) {
            HashMap<String, Double> coordinates= new HashMap<>();
            coordinates.put("latitude1", Double.valueOf(places.get(0).get("latitude")));
            coordinates.put("latitude2", Double.valueOf(places.get(i).get("latitude")));
            coordinates.put("longitude1", Double.valueOf(places.get(0).get("longitude")));
            coordinates.put("longitude2", Double.valueOf(places.get(i).get("longitude")));
            double centralAngle = computeCentralAngle(coordinates);
            Double distance = earthRadius * centralAngle;
            distances.add(distance.intValue());
        }
        return distances;
    }

    /* The following methods exist only for testing purposes and are not used
  during normal execution */
    public Distances() {
        Place place = new Place();
        Places places = new Places();

        place.put("latitude", "0.0");
        place.put("longitude", "0.0");
        places.add(place);
        places.add(place);

        this.earthRadius = 0;
        this.places = places;
        this.distances = new ArrayList<>();
    }

    public Places getPlaces() { return this.places; }

    public Integer getEarthRadius() { return this.earthRadius; }

    public ArrayList<Integer> getDistances() { return this.distances; }

}