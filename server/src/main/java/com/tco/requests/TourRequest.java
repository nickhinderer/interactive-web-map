package com.tco.requests;

import com.tco.misc.BadRequestException;
import com.tco.misc.Places;

public class TourRequest extends Request {

    private Double earthRadius;
    private Double response;
    private Places places;

    @Override
    public void buildResponse() throws BadRequestException {
        this.requestType = "tour";

    }

    /* The following methods exist only for testing purposes and are not used
  during normal execution, including the constructor. */
    public TourRequest() {
        this.requestType = "tour";
        this.earthRadius = 1.0;
        this.response = 1.0;
        this.places = new Places();
    }

    public Double getEarthRadius() {
        return earthRadius;
    }

    public Double getResponse() {
        return response;
    }

    public Places getPlaces() {
        return places;
    }
}
