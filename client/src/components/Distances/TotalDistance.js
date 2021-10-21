import React from 'react';
import { LOG } from '../../utils/constants';


export default function TotalDistance(props){

    return(
        <Row distances={props.distances} err={props.err}/>
    );
}

function Row(props){
    
        return (
            <thead>
                <tr>
                    <td><b>Trip Distance:</b></td>
                    <td>{returnTotal(props.distances, props.err)}</td>
                </tr>
            </thead>
        );
}

function returnTotal(distances, err){

    return (
        err ? "Choose at least two places to calculate distances!": Sum(distances) + " Miles"
    );
}

function Sum(distances){
    let sum = 0;
        for (let i = 0; i < distances.length; ++i) {
            sum += distances[i];
        }
        
        //For testing
        LOG.info(sum);

        return (
            sum
        );
}