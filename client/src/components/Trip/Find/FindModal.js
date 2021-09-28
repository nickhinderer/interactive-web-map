

import React, { useState } from 'react';
import { Button, Modal, ModalHeader, ModalBody, ModalFooter, InputGroupText, ListGroup, ListGroupItem } from 'reactstrap';
import { InputGroup, InputGroupAddon, Input } from 'reactstrap';
import List from './List';

const FindModal = () => {
    const [modal, setModal] = useState(false);
    const [inputLinkClicked, setInputLinkClicked] = useState(false);
    const toggle = () => setModal(!modal);
    const [display, setDisplay] = useState(false);
    const [Address, setAddress] = useState("Address");
    const [State, setState] = useState("State");
    const [City, setCity] = useState("City");
    let match = [{ id: 'Address', value: Address },
    { id: 'City', value: City },
    { id: 'State', value: State }];


   


    function updatematch() {
        match = ([{ id: 'Address', value: Address },
        { id: 'City', value: City },
        { id: 'State', value: State }]);
        //this is for test the storage of input value;
        console.log(match);
        setDisplay(!display);
        
       
    }
    
    

    const [searchInput, setsearchInput] = useState();

    return (

        <div className="searchButton">
            <Button className="mx-1" outline-color="secondary" onClick={toggle}> Search </Button>
            <Modal isOpen={modal} toggle={toggle}>
                <ModalHeader>Find Places</ModalHeader>
                <ModalBody>
                    <InputGroup>
                        <InputGroupAddon addonType="append">
                            <InputGroupText color="green">Address</InputGroupText>
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
                        <Input placeholder={State} onChange={e => {setState(e.target.value);updatematch();}} />
                    </InputGroup>


                    <Button color="primary" id="button-addon1" outline type="button" onClick={() =>setInputLinkClicked(true) }>Search </Button>
                    <br/>
                    {inputLinkClicked?<List match={match}/> :<div></div>}

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


