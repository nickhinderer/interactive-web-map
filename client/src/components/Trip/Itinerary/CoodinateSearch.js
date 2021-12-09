import React from 'react';
import  { useState } from 'react';
import { latLngToPlace } from '../../../utils/transformers'
import { Button, Modal, ModalBody, ModalHeader, ModalFooter, Input, InputGroup, InputGroupAddon, InputGroupText } from 'reactstrap';
import check from '../../../static/images/check.svg';
import Coordinates from 'coordinate-parser';
import { FaPlus } from 'react-icons/fa';

export default function CoordinateSearch(props) {   
    const { inputText, latLng, processInputChange } = useCoordinateValidation();

    return (
        <Modal isOpen={props.whereIcon} toggle={props.toggle} data-testid='where-is-modal'>
            <ModalHeader>
                Coordinate Search    
            </ModalHeader> 

                <ModalBody> 
                   <CoordinatesInput 
                        inputText={inputText}
                        latLng={latLng}
                        processInputChange={processInputChange}
                    />
                    <DisplayResults latLng={latLng} placeActions={props.placesHook.placeActions} />
                </ModalBody>

            <ModalFooter> 
                <Button color="primary" onClick={props.toggle}> <img src={check} /> </Button>
            </ModalFooter>
        </Modal>
    );
}

function useCoordinateValidation() {
    const [inputText, setInputText] = useState("");
    const [latLng, setLatLng] = useState(null);

    function processInputChange(onChangeEvent) {
        const newInputText = onChangeEvent.target.value;
        const newLatLng = getCoordinatesOrNull(newInputText);

        setInputText(newInputText);
        setLatLng(newLatLng);
    }

    return { inputText, latLng, processInputChange };
}

function getCoordinatesOrNull(coordinatesString) {
    try {
        const convertedCoordinates = new Coordinates(coordinatesString);
        return {
            lat: convertedCoordinates.getLatitude(),
            lng: convertedCoordinates.getLongitude()
        };
    } catch (error) {
        return null;
    }
}

function CoordinatesInput(props) {
    const validCoordinates = props.latLng != null;
    const inputBoxEmpty = !props.inputText;
    
    return (
        <InputGroup className="coords-input-box"> 

            <InputGroupAddon addonType="prepend">
                <InputGroupText> Coordinates </InputGroupText>                
            </InputGroupAddon> 

            <Input 
                placeholder="Latitude, Longitude"
                onChange={props.processInputChange}
                valid={validCoordinates}
                invalid={!validCoordinates && !inputBoxEmpty}
                data-testid='type-coords'
            />        
        </InputGroup>
    );
}

function DisplayResults(props) {
    if (!props.latLng) 
        return null
    
    const place = latLngToPlace(props.latLng);

    return (
        <Button color='primary'
            onClick={() => props.placeActions.append(place) }
            data-testid="add-coords-button">            
            <FaPlus/> Add
        </Button>
    );
}
