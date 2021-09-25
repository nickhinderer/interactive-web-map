
import React, { useEffect, useState } from 'react';
import { Button, Modal, ModalHeader, ModalBody, ModalFooter, InputGroupText, ListGroup, ListGroupItem } from 'reactstrap';
import { InputGroup, InputGroupAddon, Input } from 'reactstrap';
import { LOG } from '../../../utils/constants';
import { getOriginalServerUrl, sendAPIRequest } from '../../../utils/restfulAPI';

const FindModal = (props) => {
    const [modal, setModal] = useState(false);
    const toggle = () => setModal(!modal);
    const [Address, setAddress] = useState("Place");
    const [State, setState] = useState("State");
    const [City, setCity] = useState("City");
    let place = [{ id: 'Address', value: Address },
    { id: 'City', value: City },
    { id: 'State', value: State }];





    function updatePlace() {
        place = ([{ id: 'Address', value: Address },
        { id: 'City', value: City },
        { id: 'State', value: State }]);
        //this is for test the storage of input value;
        console.log(place);

    }

    return (

        <div className="searchButton">
            <Button className="mx-1" outline-color="secondary" onClick={toggle}> Search </Button>
            <Modal isOpen={modal} toggle={toggle}>
                <ModalHeader>Find Places</ModalHeader>
                <ModalBody>
                    <InputGroup>
                        <InputGroupAddon addonType="append">
                            <InputGroupText color="green" > Address</InputGroupText>

                        </InputGroupAddon>
                        <Input placeholder={Address} onChange={e => setAddress(e.target.value)} />
                    </InputGroup>

                    <InputGroup>
                        <InputGroupAddon addonType="append">
                            <InputGroupText>City</InputGroupText>

                        </InputGroupAddon>
                        <Input placeholder={City} onChange={e => setCity(e.target.value)} />

                        <InputGroupAddon addonType="append">
                            <InputGroupText>State</InputGroupText>
                        </InputGroupAddon>
                        <Input placeholder={State} onChange={e => setState(e.target.value)} />
                    </InputGroup>

                    <Button color="primary" id="button-addon1" outline type="button" onClick={() => updatePlace()}>
                        Search

                    </Button>

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
        <RenderList placesList={places} setPlacesList={setPlaces} />
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
