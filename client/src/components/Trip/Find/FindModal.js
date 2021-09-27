import React, { useState } from 'react';
import { Button, Modal, ModalHeader, ModalBody, ModalFooter, InputGroupText } from 'reactstrap';
import { InputGroup, InputGroupAddon, Input } from 'reactstrap';
import { LOG } from '../../../utils/constants';
import { getOriginalServerUrl, sendAPIRequest } from '../../../utils/restfulAPI';

export default function FindModal(props) {
    const [modal, setModal] = useState(false);
    const toggle = () => setModal(!modal);

    const [searchInput, setsearchInput] = useState();

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
                        <Input placeholder = "Place..." onChange={str => setsearchInput(str.target.value)} />
                        <Button onClick={() => sendFindRequest(searchInput, props.serverSettings.serverUrl)}/> 
                        
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


function processServerFindSuccess(find) {
    const [placeList, setPlaceList] = useState();
    setPlaceList(placeList.push(find));
}

async function sendFindRequest(searchInput, serverUrl) {
    const findResponse = await sendAPIRequest({ requestType: "find", match: searchInput, limit: 10 }, serverUrl)
    if (findResponse) {
        processServerFindSuccess(findResponse, serverUrl, setServerUrl());
    } else {
        setServerFind(null);
        showMessage('Sorry! No search requests found.');
    }
    return [{placeList: placeList}, processServerFindSuccess];
}
