import React, { useState } from 'react';
//import Distances from "../../../../server/src/main/java/com/tco/misc/Distances.java";

export default function TotalDistance(){
    //const distances = Distances.getDistances();
    return(
        <Row/>
    );
}

function Sum(props){
    let sum = 0;
    for(let i = 0; i < props.size-1; ++i){
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