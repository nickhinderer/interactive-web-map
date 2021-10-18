import React, { useState, useEffect, useCallback } from 'react';
import { Table, Button,Alert} from 'reactstrap';
import { ItineraryActionsDropdown, PlaceActionsDropdown } from './actions.js';
import { latLngToText } from '../../../utils/transformers';
import { getOriginalServerUrl, sendAPIRequest } from '../../../utils/restfulAPI';
import { Handler } from 'leaflet';
import TotalDistance from '../../Distances/TotalDistance.js';

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
            <TotalDistance />
            <Body trips={hanldeTrips} places={props.places} placeActions={props.placeActions} />
        </Table>
    );
}

function Header(props) {
    const [distances, setDistances] = useState([]);
    const [err,setERR] = useState([false]);
    

    const sendDistancesRequest = useCallback(async (data) => {
        //this is for test;
        console.log(data);
        const serverUrl = getOriginalServerUrl();
        const distancesResponse = await sendAPIRequest({ requestType: "distances", places: data, earthRadius: 6371 }, serverUrl);
        if (distancesResponse!=null) {
            distancesResponse.distances.length==0? setERR(true):setERR(false),setDistances(distancesResponse.distances); 
            
        }
        //this is for test purpose;
       console.log(distancesResponse);

    }, [])

    function getSum(){
        let SUM = 0;
        distances.map((distance)=>SUM+=distance);
        return SUM;
    }

    useEffect(() => {
        sendDistancesRequest()
    }, [sendDistancesRequest])


    return (
        <thead>
            <tr>
                <th />
                <th>My Trip {'  '}
                    <Button id="Popover1" type="button" size="sm" onClick={()=>sendDistancesRequest(props.trips) }>
                        Find Distances
                    </Button>
                    {err? <Alert color="primary"> Choose at least two places to calculate distances.</Alert>:<Alert><b>Your total Distance :</b>{getSum()} miles</Alert>}
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