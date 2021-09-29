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
        if(match == null) {
            limit = 0;
            match = "";
        }
        //validateInput(); //redundant after adding above statement
        found = queryFound(match);
        places = queryMatch(match, limit);
        log.trace("buildResponse -> {}", this);
    }

    private void validateInput() throws BadRequestException {
        if (this.limit < 0 || this.match == null) {
            throw new BadRequestException();
        }
    }

    private Integer queryFound(String match) throws BadRequestException {
        if(match.equals(""))
            return 0;
        Query query = new Query(match, -1);
        return query.findMatchingPlaces().size();
    }

    private Places queryMatch(String match, Integer limit) throws BadRequestException {
        if(match.equals(""))
            return new Places();
        Query query = new Query(match, limit);
        return query.findMatchingPlaces();
    }

    /* The following methods exist only for testing purposes and are not used
  during normal execution, including the constructor. */

    public FindRequest() {
        this.requestType = "find";
    }

    private Place samplePlace(String name, String lattitude, String longitude) {
        Place place = new Place();
        place.put("name", name);
        place.put("lattitude", lattitude);
        place.put("longitude", longitude);
        return place;
    }

    /* The following methods exist only for testing purposes and are not used
  during normal execution, including the constructor. */

    public Integer getLimit() { return limit; }

    public String getMatch() { return match; }

    public Integer getFound() { return found; }

    public Places getPlaces() { return places; }


}