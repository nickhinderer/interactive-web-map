import React, { useState, Alert } from 'react';

const[distances, setDistances] = useState([]);
const[err, setErr] = useState(false);

export default function TotalDistance(){

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
    
    return (
        <tr>
            <td>Trip Distance:</td>
            <td>{0} Miles</td>
        </tr>
    );
}

async function sendDistancesRequest(data) {

    const serverUrl = getOriginalServerUrl();
    const distancesResponse = await sendAPIRequest({ requestType: "distances", places: data, earthRadius: 3959 }, serverUrl);
    if (distancesResponse!=null) {
        distancesResponse.distances.length==0? setErr(true):setErr(false),setDistances(distancesResponse.distances); 
    }

}

function returnTotal(){
    return (
        err ? <Alert color="primary"> Choose at least two places to calculate distances.</Alert>:<Alert><b>Total Trip Distance: </b>{getSum()} miles</Alert>
    );
}