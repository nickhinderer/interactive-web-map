package com.tco.requests;

import com.tco.misc.Place;
import com.tco.misc.Places;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.tco.misc.BadRequestException;
import com.tco.database.*;

import java.util.ArrayList;

public class FindRequest extends Request {

    private final transient Logger log = LoggerFactory.getLogger(FindRequest.class);

    private String match;
    private Integer limit;
    private ArrayList<String> type;
    private ArrayList<String> where;
    private Integer found;
    private Places places;

    @Override
    public void buildResponse() throws BadRequestException {
        if(type != null || where != null)
            throw new BadRequestException();
        found = queryFound(match);
        places = queryMatch(match, limit);
        log.trace("buildResponse -> {}", this);
    }


    private Integer queryFound(String match) throws BadRequestException {
        Query query = new Query(match, -1);
        return query.findNumberOfMatches();//call findnumberofmatches instead
    }

    private Places queryMatch(String match, Integer limit) throws BadRequestException {
        //set limit to 100 if it is 0
        Query query = new Query(match, limit);//going to be between 0 and 100
        if(match.equals(""))
            return query.findRandomPlaces();
        return query.findMatchingPlaces();
    }


    /* The following methods exist only for testing purposes and are not used
  during normal execution, including the constructor. */

    public FindRequest() {
        this.requestType = "find";
        this.match = "_TEST_VALUE_";
        this.limit = 0;
    }

    public String getRequestType() { return requestType; }

    public Integer getLimit() { return limit; }

    public String getMatch() { return match; }

    public Integer getFound() { return found; }

    public Places getPlaces() { return places; }

}