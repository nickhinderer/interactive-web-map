import React, { useState, Alert, Button } from 'react';
import { getOriginalServerUrl, sendAPIRequest } from '../../utils/restfulAPI';

export default function TotalDistance(props){
    //const trips = props.trips;
    //figure out how to pass trip to distance request when button clicked

    return(
        <Row/>
    );
}

function Sum(props){
        let sum = 0;
        for(let i = 0; i < props.length; ++i){
            sum += props[i];
        }

        return sum;
    }

    function Row(props){
    //need to pass distances to Sum() then show here
        return (
            <thead>
                <tr>
                    <td>Trip Distance:</td>
                    <td>{0} Miles</td>
                </tr>
            </thead>
        );
    }

    async function sendDistancesRequest(data) {
        const[distances, setDistances] = useState([]);
        const[err, setErr] = useState(false);

        const serverUrl = getOriginalServerUrl();
        const distancesResponse = await sendAPIRequest({ requestType: "distances", places: data, earthRadius: 3959 }, serverUrl);
        if (distancesResponse!=null) {
            distancesResponse.distances.length==0? setErr(true):setErr(false),setDistances(distancesResponse.distances); 
        }

        function returnTotal(props){
            return (
                err ? <Alert color="primary"> Choose at least two places to calculate distances!</Alert>:<Alert>{Sum(props)} Miles</Alert>
                //figure out how to grab err from distance request
            );
        }
        
        return(
            returnTotal(distances)
        );
    }