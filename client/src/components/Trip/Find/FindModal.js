
import React, { useState } from 'react';
import { Button, Modal, ModalHeader, ModalBody, ModalFooter, Input, InputGroup, InputGroupAddon} from 'reactstrap';
import List from './List';
import mag from '../../../static/images/search.svg';
import check from '../../../static/images/check.svg';
import x from '../../../static/images/x.svg';

export default function FindModal(props) {
    const [modal, setModal] = useState(false);
    const toggle = () => setModal(!modal);
    const [display, setDisplay] = useState(false);
    const [match, setMatch] = useState("");

 
   
    return (

        <div className="searchButton">
            <Button className="mx-1" outline-color="secondary" onClick={toggle}><img src={mag} alt='search'/></Button>
            <Modal isOpen={modal} toggle={toggle}>
                <ModalHeader>Find Places</ModalHeader>
                <ModalBody>
                {FindInput(setDisplay, setMatch)}
                {display? <List match={match} places={props.places} placeActions={props.placeActions}/> :<div></div>}
                </ModalBody>
                <ModalFooter>
                    <Button color="primary" onClick={toggle}><img src={check}/> Done </Button>{' '}
                    <Button color="danger" onClick={toggle}><img src={x}/> Cancel </Button>
                </ModalFooter>
            </Modal>
        </div>
    );
}

function FindInput(setDisplay, setMatch){

    return (
        <InputGroup>
            <Input placeholder={"Place..."} onChange={e => {setMatch(e.target.value); setDisplay(false);}} />
                <InputGroupAddon addonType="append">
                    <Button color="primary" id="button-addon1" outline type="button" onClick={() =>{setDisplay(true)} }>Search </Button>
                </InputGroupAddon>
        </InputGroup>
    );
}

