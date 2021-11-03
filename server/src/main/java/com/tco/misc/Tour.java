package com.tco.misc;

public class Tour {
    private Places places;
    private final double earthRadius;
    private final Double response;

    private int[] bestTour;
    private long[][] distancesMatrix;

    public Tour(Places places, double earthRadius, Double response) {
        this.places = places;
        this.earthRadius = earthRadius;
        this.response = response;
    }

    public void optimizeTour() {

    }

    /* The following methods exist only for testing purposes and are not used
       during normal execution */
    public Tour() {
        this.places = new Places();
        this.earthRadius = 3958.8;
        this.response = 1.0;
    }

    public Places getPlaces() {
        return places;
    }

    public double getEarthRadius() {
        return earthRadius;
    }

    public Double getResponse() {
        return response;
    }

    public void setPlaces(Places places) {
        this.places = places;
    }

    public long getTourDistance() {
        long totalDistance = 0;
        for (int i = 0; i < places.size(); i++) {
            if (i != places.size() - 1)
                totalDistance += distancesMatrix[bestTour[i]][bestTour[i + 1]];
            else
                totalDistance += distancesMatrix[bestTour[i]][bestTour[0]];
        }
        return totalDistance;
    }

}