package com.tco.requests;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FindRequest extends Request {

    private final transient Logger log = LoggerFactory.getLogger(ConfigRequest.class);

    private String match;
    private Integer limit;
    private Integer found;
    private Places places;

    @Override
    public void buildResponse() {
        limit = 0;
        match = "";
        found = queryFound();
        places = queryMatch();
        log.trace("buildResponse -> {}", this);
    }

    /* The following methods exist only for testing purposes and are not used
  during normal execution, including the constructor. */

    public FindRequest() {
        this.requestType = "find";
    }

    private Integer queryFound() {
        return 1;
    }

    private Places queryMatch() {
        places = new Places();

        places.add(samplePlace("COse", "41","-102"));
        return places;
    }

    private Place samplePlace(String name, String lattitude, String longitude) {
        Place place = new Place();
        place.put("name", name);
        place.put("lattitude", lattitude);
        place.put("longitude", longitude);
        return place;
    }
      /* this is for test*/

      public int getlimit() {
        return limit;
    }

    public String getMatch(){

        return match;
    }

    
}