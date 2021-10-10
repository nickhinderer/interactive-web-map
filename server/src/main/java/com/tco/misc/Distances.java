package com.tco.misc;

import java.util.ArrayList;

public class Distances {
    private ArrayList<Places> places;
    private ArrayList<Integer> distances;
    private Integer earthRadius;

    public Distances(ArrayList<Places> places, Integer earthRadius) {
        this.places = places;
        this.earthRadius = earthRadius;
        this.distances = new ArrayList<>();
    }


    public ArrayList<Integer> computeDistances() {
        return new ArrayList<>();
    }
}