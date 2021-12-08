package com.tco.misc;

import java.util.Arrays;
import java.util.HashMap;

public class Tour {
    private Places places;
    private final double earthRadius;
    private Double response;

    private long[][] distancesMatrix;
    private boolean[] visited;

    private Place currentCity;
    private int[] currentTour;
    private int[] bestTour;


    public Tour(Places places, double earthRadius, Double response) {
        this.places = places;
        this.earthRadius = earthRadius;
        this.response = response;

        distancesMatrix = new long[places.size()][places.size()];
        visited = new boolean[places.size()];
        currentTour = new int[places.size()];
        bestTour = new int[places.size()];
    }

    public Places optimizeTour() {
        calculateDistancesMatrix();

        long startTime = System.currentTimeMillis();
        response *= 1000;
        response -= 500;
        long endTime = startTime + response.longValue(); //subtract the overhead for calculateDistancesMatrix and updateTourOrder (even though it is minuscule, it is still non-zero)

        while (System.currentTimeMillis() < endTime) {
            createNearestNeighborTour();
            //twoOpt();
        }

        if (response > 0.0)
            updateTourOrder();
        return places;
    }

    private void twoOpt() {
        boolean improvement = true;
        while (improvement) {
            improvement = false;
            for (int i = 0; i <= places.size()-1 - 3; i++) {

            }
        }
    }

    private boolean twoOptImproves(int i, int k) {
        return distancesMatrix[i][k] + distancesMatrix[i+1][k+1] < distancesMatrix[i][i+1] + distancesMatrix[k][k+1];
    }

    private void twoOptReverse(int i1, int k) {
        while (i1 < k) {
            int temp = bestTour[i1];
            bestTour[i1] = bestTour[k];
            bestTour[k] = temp;
            i1++;
            k--;
        }
        updateTourOrder();
        calculateDistancesMatrix();
    }

    private void calculateDistancesMatrix() {
        for (int i = 0; i < places.size(); ++i) {
            for (int j = i + 1; j < places.size(); ++j) {
                HashMap<String, Double> coordinates = new HashMap<>();
                coordinates.put("latitude1", Double.valueOf(places.get(i).get("latitude")));
                coordinates.put("longitude1", Double.valueOf(places.get(i).get("longitude")));
                coordinates.put("latitude2", Double.valueOf(places.get(j).get("latitude")));
                coordinates.put("longitude2", Double.valueOf(places.get(j).get("longitude")));
                distancesMatrix[i][j] = Math.round(Math.abs(earthRadius * Distances.computeCentralAngle(coordinates)));
                distancesMatrix[j][i] = distancesMatrix[i][j];
                distancesMatrix[i][i] = 0L;
                distancesMatrix[j][j] = 0L;
            }
        }
    }

    private void createNearestNeighborTour() {
        long bestTourDistance = Long.MAX_VALUE;
        for (Place startingCity : places) {
            Arrays.fill(visited, false); //reset trip
            currentCity = startingCity;
            long currentTourDistance = calculateNearestNeighborTourDistance();
            if (currentTourDistance < bestTourDistance) {
                bestTourDistance = currentTourDistance;
                bestTour = currentTour.clone();
            }
        }
    }

    private long calculateNearestNeighborTourDistance() {
        long tourDistance = 0L;
        for (int i = 0; i < places.size(); i++) {
            visited[places.indexOf(currentCity)] = true;
            currentTour[i] = places.indexOf(currentCity);
            int indexOfShortestDistance = calculateNearestNeighborIndex();
            if (indexOfShortestDistance == -1) { //case: all destinations have been visited
                tourDistance += distancesMatrix[currentTour[0]][currentTour[places.size() - 1]]; //add return leg
            } else {
                tourDistance += distancesMatrix[places.indexOf(currentCity)][indexOfShortestDistance];
                visited[indexOfShortestDistance] = true; //mark city as visited
                currentCity = places.get(indexOfShortestDistance); //move to next city
            }
        }
        return tourDistance;
    }

    private int calculateNearestNeighborIndex() {
        int indexOfCurrent = 0, indexOfShortestDistance = -1;
        long shortestDistance = Long.MAX_VALUE;

        for (long currentDistance : distancesMatrix[places.indexOf(currentCity)]) {
            if (!visited[indexOfCurrent] && currentDistance < shortestDistance) {
                shortestDistance = currentDistance;
                indexOfShortestDistance = indexOfCurrent;
            }
            indexOfCurrent++;
        }

        return indexOfShortestDistance;
    }

    private void updateTourOrder() {
        Places newTrip = new Places();
        int startingIndex = getStartingIndex();
        for (int i = 0; i < places.size(); i++)
            newTrip.add(places.get(bestTour[(startingIndex + i) % bestTour.length]));
        places = newTrip;
    }

    private int getStartingIndex() {
        Integer[] searchArray = new Integer[bestTour.length];
        int i = 0;
        for (int value : bestTour)
            searchArray[i++] = value;
        return Arrays.asList(searchArray).indexOf(0);
    }

    /* The following methods exist only for testing purposes and are not used
       during normal execution */
    public Tour() {
        this.places = new Places();
        this.earthRadius = 3958.8;
        this.response = 0.6;
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

    public void setInstanceVariables() {
        distancesMatrix = new long[places.size()][places.size()];
        visited = new boolean[places.size()];
        currentTour = new int[places.size()];
        bestTour = new int[places.size()];
    }

}
