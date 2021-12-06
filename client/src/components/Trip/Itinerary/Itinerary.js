import React, { useState, useEffect } from 'react';
import { Table, Button, Modal, Label } from 'reactstrap';
import { ItineraryActionsDropdown, PlaceActionsDropdown } from './actions.js';
import { latLngToPlace, latLngToText } from '../../../utils/transformers';
import { getOriginalServerUrl, sendAPIRequest } from '../../../utils/restfulAPI';
import TotalDistance from '../../Distances/TotalDistance.js';
import { LOG } from '../../../utils/constants';
import Tour,{sendTourRequest} from '../../Tour/Tour.js';
import { FaArrowCircleDown, FaTelegramPlane } from 'react-icons/fa';
import TripName from './TripName.js';
import { BiTargetLock } from 'react-icons/bi';

export default function Itinerary(props) {
    const [err, setErr] = useState(true);
    const [distances, setDistances]=useState([]);

    async function sendDistancesRequest(data){

        const serverUrl = getOriginalServerUrl();
        const distancesResponse = await sendAPIRequest({ requestType: "distances", places: data, earthRadius: 3959 }, serverUrl);
        if (distancesResponse!=null) {
            distancesResponse.distances.length==0? setErr(true):setErr(false),setDistances(distancesResponse.distances); 
        }
    }

    return (
        <Table responsive >
            <Header tripName={props.tripName} places={props.places} placeActions={props.placeActions} send={(places) => sendDistancesRequest(places)} />
            <TotalDistance distances={distances} err={err}/>
            <Body places={props.places} placeActions={props.placeActions} distances={distances} onChange={sendTourRequest(props.places,getOriginalServerUrl())} />
        </Table>
    );
}

function handleChange(places, send) {
    const newPlaces = [];
    for (var i = 0; i < places.length; i++) {          
        const matchingType = latLngToPlace(places[i]);
        newPlaces.push(matchingType);       
    }
    send(newPlaces);
}

function Header(props) {
    var display = false;
    return (
        <thead>
            
            <tr>
                <th><TripName   display = {display}/><FaArrowCircleDown/></th>
                <th>
                    <Button id="Popover1" type="button" size="sm" onClick={() => handleChange(props.places, props.send)}>
                        Find Distances
                    </Button>
                </th> 
                <th>
                    <Tour places={props.places} placeActions={props.placeActions}/>
                </th>
                <th>
                    <ItineraryActionsDropdown placeActions={props.placeActions} />
                </th>
            </tr>
        </thead>
    );
}

function Body(props) {

    return (
        <tbody>
            {props.places.map((place, index) =>
                <TableRow
                    key={`table-${JSON.stringify(place)}-${index}`}
                    place={place}
                    placeActions={props.placeActions}
                    index={index}
                    distance={props.distances[index-1]}
                />
            )}
        </tbody>
    );
}

function TableRow(props) {
    const name = props.place.name ? props.place.name : "-";
    const location = latLngToText(props.place);
    const distance = props.distance;

    const [bgColor, setColor] = useState('white');

    function moveMarker(){
        props.placeActions.selectIndex(props.index);
        changeColor();
    }

    function changeColor(){
        setColor('#D3D3D3');
    }

    return (
        <tr bgcolor={bgColor} onClick={() => moveMarker()} onMouseLeave={() => setColor('white')}>
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