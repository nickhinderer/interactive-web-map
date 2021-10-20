import React, { useState, Alert, Button, useCallback } from 'react';
import { getOriginalServerUrl, sendAPIRequest } from '../../utils/restfulAPI';

//Need to fix these so that err/distances update
//Very close to working

const distances = [];
const err = false;

function setErr(boolVal){
    err = boolVal;
}

function setDistances(listVal){
    distances = listVal;
}

export default function TotalDistance(props){
    //const trips = props.trips;
    //figure out how to pass trip to distance request when button clicked

    return(
        <Row/>
    );
}

export async function sendDistancesRequest(data){

        const serverUrl = getOriginalServerUrl();
        const distancesResponse = await sendAPIRequest({ requestType: "distances", places: data, earthRadius: 3959 }, serverUrl);
        if (distancesResponse!=null) {
            distancesResponse.distances.length==0? setErr(true):setErr(false),setDistances(distancesResponse.distances); 
        }
        
    }

    function Row(){
        //need to pass distances to Sum() then show here
        //const trips = props.trips
            return (
                <thead>
                    <tr>
                        <td><b>Trip Distance:</b></td>
                        <td>{returnTotal()}</td>
                    </tr>
                </thead>
            );
        }

        function returnTotal(){

            return (
                err ? "Choose at least two places to calculate distances!": Sum(distances) + " Miles"
            );
        }

        function Sum(distances){
            let sum = 0;
            for (let i = 0; i < distances.length; ++i) {
                sum += distances[i];
            }
    
            return (
                sum
            );
        }