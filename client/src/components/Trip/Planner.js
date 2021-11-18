import React from 'react';
import { Col, Container, Input, Row } from 'reactstrap';
import Find from './Find/FindModal';
import Map from './Map/Map';
import Itinerary from './Itinerary/Itinerary';
import { usePlaces } from '../../hooks/usePlaces';

const FILE_FORMATS = ".json, .csv, application/json, text/csv";

export default function Planner(props) {
    const {places, selectedIndex, placeActions} = usePlaces();

    return (
        <Container>
            <Section>
                <Find places={places} selectedIndex={selectedIndex} placeActions={placeActions} serverSettings={props.serverSettings}/>
            </Section>
            <Section>
                <Map places={places} selectedIndex={selectedIndex} placeActions={placeActions} />
            </Section>
            <Section>
                <Itinerary places={places} selectedIndex={selectedIndex} placeActions={placeActions} />
                <LoadFileInput placeActions={placeActions} />
            </Section>
        </Container>
    );
}

function Section(props) {
    return (
        <Row>
            <Col sm={12} md={{ size: 10, offset: 1 }}>
                {props.children}
            </Col>
        </Row>
    );
}

export function LoadFileInput(props) {
    function handleFileUpload(event) {
        const fileName = event.target.files[0].name;
        const fileObject = event.target.files[0];
        props.placeActions.readFile(fileName, fileObject);
    }

    return (
        <Input data-testid="file-upload" type="file" accept={FILE_FORMATS} onChange={handleFileUpload} hidden />
    );
}