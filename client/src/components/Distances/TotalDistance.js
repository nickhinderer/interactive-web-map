import React, { useState } from 'react';
import { Table } from 'reactstrap';
import distances from "../../../../server/src/main/java/com/tco/misc/Distances.java"

export default function TotalDistance(props){
    <Table>
        <Row></Row>
    </Table>
}

function Sum(props){
    for(i = 0; i < props.size; ++i){
        sum += props[i];
    }

    return sum;
}

function Row(props){
    const [sum] = Sum(props.distances);
    return (
        <tr>
            <td>Table:</td>
            <td>{props.sum}</td>
        </tr>
    );
}