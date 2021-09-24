
import React, { useEffect, useState } from 'react';
import { Button, Modal, ModalHeader, ModalBody, ModalFooter, InputGroupText, ListGroup, ListGroupItem } from 'reactstrap';
import { InputGroup, InputGroupAddon, Input } from 'reactstrap';
import { LOG } from '../../../utils/constants';
import { getOriginalServerUrl, sendAPIRequest } from '../../../utils/restfulAPI';

const FindModal = () => {
    const [modal, setModal] = useState(false);
    const toggle = () => setModal(!modal);

    return (

        <div className="searchButton">
            <Button className = "mx-1" outline-color="secondary" onClick={toggle}> Search </Button>
            <Modal isOpen={modal} toggle={toggle}>
                <ModalHeader>Find Places</ModalHeader>
                <ModalBody>
                    <InputGroup>
                        <InputGroupAddon addonType="append">
                            <InputGroupText>Search</InputGroupText>
                        </InputGroupAddon>
                        <Input placeholder = "Place..." onClick={progressiveDisclosure()}/>
                    </InputGroup>
                </ModalBody>
                <ModalFooter>
                    <Button color="success" onClick={toggle}>Done</Button>{' '}
                    <Button color="danger" onClick={toggle}>Cancel</Button>
                </ModalFooter>
            </Modal>
        </div>
    );
}
export default FindModal;

function progressiveDisclosure() {    
    const [places, setPlaces] = useState([]);

    <div>
        <RenderList placesList={places} setPlacesList={setPlaces}/>
    </div>
}

function RenderList(props) {
    const [serverUrl, setServerUrl] = useState(getOriginalServerUrl());

    const listPlaces = props.placesList.map((place) =>
        <li key={place.toString()}>
            {place}
        </li>
    );

    useEffect(() => {
        sendFindRequest();
    }, []);

    function processServerFindSuccess(find, url) {
        LOG.info("Looking for matches.", url);
        setServerUrl(url);
        props.setPlacesList(find);
    }
    
    async function sendFindRequest() {
        const findResponse = await sendAPIRequest({ requestType: "find", match: " ", limit: " " }, serverUrl)
        if (findResponse) {
            processServerFindSuccess(findResponse, serverUrl);
        } else {
            setServerUrl(null);
            showMessage('Sorry! No search requests found.');
        }
        return [{ serverUrl: serverUrl, places: places }, processServerFindSuccess];
    }
    return (
        <ul>{listPlaces}</ul>
    );
} 
