import React, { useEffect, useState } from 'react';
import { Button, Modal, ModalHeader, ModalBody, ModalFooter, Input, InputGroup, InputGroupAddon} from 'reactstrap';
import List from './List';
import mag from '../../../static/images/search.svg';
import check from '../../../static/images/check.svg';
import x from '../../../static/images/x.svg';
import {GiPerspectiveDiceSixFacesRandom} from "react-icons/gi";

export default function FindModal(props) {
    const [modal, setModal] = useState(false);
    const toggle = () => setModal(!modal);
    const [display, setDisplay] = useState(false);
    const [match, setMatch] = useState("");

    useEffect(() => {
        setDisplay(false);
    }, [modal])

    return (

        <div className="searchButton">
            <Button className="mx-1" outline-color="secondary" onClick={toggle}> <img src={mag} alt='search'/> </Button>
            <Modal isOpen={modal} toggle={toggle}>
                <ModalHeader>Find Places</ModalHeader>

                <ModalBody>
                <b>Type</b> to add a place to itinerary
                <FindInput setDisplay={setDisplay} setMatch={setMatch} />
                <List display={display} setDisplay={setDisplay} match={match} places={props.places} placeActions={props.placeActions}/>
                </ModalBody>

                <ModalFooter>
                    <Button color="primary" onClick={toggle}><img src={check}/> Done </Button>
                    <Button color="danger" onClick={toggle}> <img src={x}/> Cancel </Button>
                </ModalFooter>
            </Modal>
        </div>
    );
}

export function FindInput(props){

    return (
        <InputGroup>
            <Input placeholder={"Click Icon for Random Places"} onChange={e => {props.setMatch(e.target.value); props.setDisplay(true);}} />
                <InputGroupAddon addonType="append">
                    <Button color="primary"  onClick={() =>{props.setMatch(String.fromCharCode(65+Math.floor(Math.random() * 26)));props.setDisplay(true)} }> <GiPerspectiveDiceSixFacesRandom/></Button>
                </InputGroupAddon>
        </InputGroup>
    );
}