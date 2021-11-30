import React, { useState } from 'react';
import { Button, Modal, ModalHeader,  ModalFooter } from 'reactstrap';
import { sendAPIRequest } from '../../utils/restfulAPI';


let newTirp = [];

export function setNewPlaces(newPlaces){
    newTirp = newPlaces;
}

export function getSize(){
    return newTirp.length;
}

export function getNewPlaces(){
    var trip = [];
    let newPlaces=getTrip();
    newPlaces.map((place)=> trip.push({ name: place.name, lat: parseFloat(place.latitude), lng: parseFloat(place.longitude)}));
    return trip;
}

export function getTrip(){
    return newTirp;
}



export default function Tour(props) {
    const [modal, setModal] = useState(false);
    const toggle = () => setModal(!modal);
    
   function hanldeModal(){
        setModal(!modal);
    }

    return (
        <div className="Tour-modal">
           <Button data-testid="shorter-trip" size="sm" outline-color="secondary" onClick={toggle}>Find Shorter Trip</Button>
            <Modal data-testid="modal" isOpen={modal} >
            <Body data-testid="body" newplace = {props.newTirp} hanldeModal ={hanldeModal} placeActions={props.placeActions} toggle={toggle}></Body>       
            </Modal>
        </div>
    );


}

function Body(props){
    function Toggle(){ 
        props.hanldeModal();
    }
    return(      
            getSize()? <><ModalHeader>A shorter trip found.<br /> Apply shorter trip? </ModalHeader ><ApplyFooter placeActions={props.placeActions} toggle={props.toggle} Toggle={Toggle}/> </>:<><ModalHeader>Current Trip is the shortest trip.</ModalHeader>{ExitFooter (props.toggle)}</>
    );
}

export function ApplyFooter(props){
    function hanldeClick(){
        var newPlaces = getNewPlaces();
        props.placeActions.update(newPlaces);
        props.Toggle();
    }
   
    return (
    <ModalFooter>
        <Button data-testid="Apply" color="primary" type="button" onClick={()=>{hanldeClick()}}> Apply </Button>
        <Button color="danger" onClick={props.toggle}>Discard </Button>
    </ModalFooter>
    );
}

export function ExitFooter(toggle){
    return (
    <ModalFooter>
        <Button color="primary" onClick={toggle}> Exit </Button>
    </ModalFooter>
    );
}

export async function sendTourRequest(places,serverUrl){
    var Places = hanldePlaces ( places,'old')
    const OptmizationResponse = await sendAPIRequest({ requestType: "tour", earthRadius: 3959, response: 1.0,  places: Places  }, serverUrl);
    if (OptmizationResponse) {   
        var newPlaces = hanldePlaces(OptmizationResponse.places,'new');  
        if(JSON.stringify(Places)!=JSON.stringify(newPlaces)){
            setNewPlaces(newPlaces);      
        }else
        setNewPlaces([]);
    }
   

}

export function hanldePlaces(places,Type){
    var trip = [];
    if(Type == 'old'){
        places.map((place) => trip.push({ "name": place.name, "latitude": place.lat.toString(), "longitude": place.lng.toString() }));
    }else{
        places.map((place) => trip.push({ "name": place.name, "latitude": place.latitude.toString(), "longitude": place.longitude.toString() }));
    }
    return trip;
}







