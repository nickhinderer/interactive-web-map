import React, { useState, useEffect, useCallback } from 'react';
import { Table, Button, Popover, PopoverHeader, PopoverBody } from 'reactstrap';
import { ItineraryActionsDropdown, PlaceActionsDropdown } from './actions.js';
import { latLngToText } from '../../../utils/transformers';
import { getOriginalServerUrl, sendAPIRequest } from '../../../utils/restfulAPI';
import { Handler } from 'leaflet';

export default function Itinerary(props) {
    const [trips, setTrips] = useState([]);



    function hanldeTrips(trip, size) {

        useEffect(() => {
            setTrips(trip);
            //this is for test purpose
            console.log(trips);
        }, [size != trips.length]);
    }

    return (
        <Table responsive striped>
            <Header placeActions={props.placeActions} trips={trips} />
            <Body trips={hanldeTrips} places={props.places} placeActions={props.placeActions} />
        </Table>
    );
}

function Header(props) {
    const [distances, setDistances] = useState([]);

    const sendDistancesRequest = useCallback(async (data) => {
        //this is for test;
        console.log(data);
        const serverUrl = getOriginalServerUrl();
        const distancesResponse = await sendAPIRequest({ requestType: "distances", places: data, earthRadius: 6371 }, serverUrl);
        if (distancesResponse!=null) {
            distancesResponse.distances.length==0? alert("Require at least two place to calculate distances.") :setDistances(distancesResponse.distances); 
            
        }
        //this is for test purpose;
       console.log(distancesResponse);

    }, [])

    useEffect(() => {
        sendDistancesRequest()
    }, [sendDistancesRequest])


    return (
        <thead>
            <tr>
                <th />
                <th>My Trip
                </th>
                <th>
                    <Button onClick={()=>sendDistancesRequest(props.trips)}>
                        Find Distances
                    </Button>
                </th>
                <th>
                    <ItineraryActionsDropdown placeActions={props.placeActions} />
                </th>
            </tr>
        </thead>
    );
}

function Body(props) {


    function hanldeChange() {
        const trip = [];
        props.places.map((place) => trip.push({ "name": place.name.split(",")[0], "latitude": place.lat.toString(), "longitude": place.lng.toString() }));
        const size = trip.length; 
        props.trips(trip, size);
    }

    return (
        <tbody onChange={hanldeChange()}>
            {props.places.map((place, index) =>
                <TableRow
                    key={`table-${JSON.stringify(place)}-${index}`}
                    place={place}
                    placeActions={props.placeActions}
                    index={index}
                />
            )}
        </tbody>
    );
}

function TableRow(props) {
    const name = props.place.name ? props.place.name : "-";
    const location = latLngToText(props.place);

    return (
        <tr>
            <th scope="row">{props.index + 1}</th>
            <td>
                {name}
                <br />
                <small className="text-muted">{location}</small>
            </td>
            <td>
                <PlaceActionsDropdown placeActions={props.placeActions} index={props.index} />
            </td>
        </tr>
    );
}