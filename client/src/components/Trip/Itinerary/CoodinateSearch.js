import React from 'react';
import  { useState } from 'react';
import { Button, Modal, ModalBody, ModalHeader, ModalFooter, Input, InputGroup, InputGroupAddon } from 'reactstrap';
import check from '../../../static/images/check.svg';
import x from '../../../static/images/x.svg';
import Coordinates from 'coordinate-parser';
import { FaPlus } from 'react-icons/fa';

export default function CoordinateSearch(props) {   
    const [display, setDisplay] = useState(false); // This will come into play later

    const { inputText, latLng, processInputChange } = useCoordinateValidation();

    return (
        <Modal isOpen={props.whereIcon} toggle={props.toggle} data-testid='where-is-modal'>
            <ModalHeader>
                Coordinate Search    
            </ModalHeader> 

                <ModalBody> 
                   <CoordinatesInput> 
                        inputText={inputText}
                        latLng={latLng}
                        processInputChange={processInputChange}
                   </CoordinatesInput>
                </ModalBody>

            <ModalFooter> 
                <Button color="primary" onClick={props.toggle}> <img src={check} /> </Button>
                <Button color="danger" onClick={props.toggle}> <img src={x} /> </Button>
            </ModalFooter>
        </Modal>
    );
}

function useCoordinateValidation() {
    const [inputText, setInputText] = useState("");
    const [latLng, setLatLng] = useState(null);

    function processInputChange(onChangeEvent) {
        
    }

    return { inputText, latLng, processInputChange };
}

function CoordinatesInput() {
    return null;
}

function DisplayResults() {
    return null;
}

function noResult(){
    return (
        <div style={{display: 'flex', justifyContent:'center', alignItems:'center', height:'20vh'}}> 
            <p> No results found </p> 
        </div>
    );
}