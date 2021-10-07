package com.tco.requests;

import com.tco.misc.Place;
import com.tco.misc.Places;
import com.tco.misc.Distance;
import com.tco.misc.Distances;

import com.tco.misc.BadRequestException;

public class DistanceRequest extends Request {

    private Places places; 
    private int earthRadius;
    private Distances distances;

    @Override
    public void buildResponse() throws BadRequestException {

    }

    /* The following methods exist only for testing purposes and are not used
  during normal execution, including the constructor. */
    
    public DistanceRequest() { 
        this.requestType = "distances";
        this.earthRadius = -2;
        this.distances = new Distances();
        this.places = new Places();
    }    
    
    private Place samplePlace(String name, String latitude, String longitude) {
        Place place = new Place();
        place.put("name", name);
        place.put("latitude", latitude);
        place.put("longitude", longitude);
        return place;
    }

    public String getRequestType() { return requestType; }

    public Places getPlaces() { return places; }
    
    public int getEarthRadius() { return earthRadius; }

    public Distances getDistances() { return distances; }

}
