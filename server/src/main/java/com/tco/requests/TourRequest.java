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
}
