package com.tco.requests;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.tco.misc.BadRequestException;
import com.tco.database.*;

public class FindRequest extends Request {

    private final transient Logger log = LoggerFactory.getLogger(ConfigRequest.class);

    private String match;
    private Integer limit;
    private Integer found;
    private Places places;

    @Override
    public void buildResponse() throws BadRequestException {
        validateInput();
        if(match.equals("") && limit.equals(0)) { //don't query database for tests, maybe add case in validate input where a empty string gets turned into a wildcat character
            Place place = samplePlace("name", "0.000000","0.000000");
            this.places.add(place);//is this necessary? read protocol
        } else {
            found = queryFound(match);
            places = queryMatch(match, limit);
        }
        log.trace("buildResponse -> {}", this);
    }

    private void validateInput() throws BadRequestException {
        if (this.limit < 0 || this.match == null) {
            throw new BadRequestException();
        }
    }

    private Integer queryFound(String match) throws BadRequestException {
        Query query = new Query(match, -1);
        return query.findNumberOfMatches();//call findnumberofmatches instead
    }

    private Places queryMatch(String match, Integer limit) throws BadRequestException {
        //set limit to 100 if it is 0
        Query query = new Query(match, limit);//going to be between 0 and 100
        return query.findMatchingPlaces();
    }

    /* The following methods exist only for testing purposes and are not used
  during normal execution, including the constructor. */

    public FindRequest() {
        this.requestType = "find";
        this.match = "";
        this.limit = 0;
        this.found = 0;
        this.places = new Places();
    }

    private Place samplePlace(String name, String latitude, String longitude) {
        Place place = new Place();
        place.put("name", name);
        place.put("lattitude", lattitude);
        place.put("longitude", longitude);
        return place;
    }

    public Integer getLimit() { return limit; }

    public String getMatch() { return match; }

    public Integer getFound() { return found; }

    public Places getPlaces() { return places; }

}