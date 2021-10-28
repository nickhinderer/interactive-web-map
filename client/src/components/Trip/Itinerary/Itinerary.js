import React, { useState, useEffect } from 'react';
import { Table, Button} from 'reactstrap';
import { ItineraryActionsDropdown, PlaceActionsDropdown } from './actions.js';
import { latLngToText } from '../../../utils/transformers';
import { getOriginalServerUrl, sendAPIRequest } from '../../../utils/restfulAPI';
import { Handler } from 'leaflet';
import TotalDistance from '../../Distances/TotalDistance.js';
import { LOG } from '../../../utils/constants';

export default function Itinerary(props) {
    const [trips, setTrips] = useState([]);
    const [err, setErr] = useState(true);
    const [distances, setDistances]=useState([]);



    function hanldeTrips(trip, size) {

        useEffect(() => {
            setTrips(trip);
            //this is for test purpose
            console.log(trips);
        }, [size != trips.length]);
    }

    async function sendDistancesRequest(data){

        const serverUrl = getOriginalServerUrl();
        const distancesResponse = await sendAPIRequest({ requestType: "distances", places: data, earthRadius: 3959 }, serverUrl);
        if (distancesResponse!=null) {
            distancesResponse.distances.length==0? setErr(true):setErr(false),setDistances(distancesResponse.distances); 
        }
    
        //For testing purposes
        //LOG.info(distancesResponse);
        //LOG.info(distances);
    }

    return (
        <Table responsive striped>
            <Header placeActions={props.placeActions} send={sendDistancesRequest} trips={trips} />
            <TotalDistance distances={distances} err={err}/>
            <Body trips={hanldeTrips} places={props.places} placeActions={props.placeActions} distances={distances} />
        </Table>
    );
}

function Header(props) {
    
    function hanldeChange(data){
        props.send(data);
    }

    return (
        <thead>
            <tr>
                <th>My Trip</th>
                <th>
                    <Button id="Popover1" type="button" size="sm" onClick={() => hanldeChange(props.trips)}>
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

    /*
    function hanldeChange() {
        const trip = [];
        props.places.map((place) => trip.push({ "name": place.name.split(",")[0], "latitude": place.lat.toString(), "longitude": place.lng.toString() }));
        const size = trip.length; 
        props.trips(trip, size);
    } */

    return (
        <tbody>
            {props.places.map((place, index) =>
                <TableRow
                    key={`table-${JSON.stringify(place)}-${index}`}
                    place={place}
                    placeActions={props.placeActions}
                    index={index}
                    distance={props.distances[index]}
                />
            )}
        </tbody>
    );
}

function TableRow(props) {
    const name = props.place.name ? props.place.name : "-";
    const location = latLngToText(props.place);
    const distance = props.distance;

    return (
        <tr>
            <th scope="row">{props.index + 1}</th>
            <td>{ props.index != 0 && distance != 0 ? distance : 0} Mile(s)</td>
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