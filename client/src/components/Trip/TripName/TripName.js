import React,{useState} from 'react';
import { Button, Modal, ModalHeader, ModalBody, ModalFooter, Input, InputGroup, InputGroupAddon} from 'reactstrap';
import {FaPlus} from 'react-icons/fa';
export default function TripName(props) {
    const [tripName,setTripName] = useState("My Trip");
    const [display, setDisplay] = useState(props.display);
    if (display){
        return (
          
                <InputGroup> 
                    <Input  bsSize="sm"  placeholder={"Modify your Trip Name here"} onChange={e => setTripName(checkInput(e.target.value))} />
                    <InputGroupAddon addonType="append">
                        <Button  size = "sm" onClick={()=>setDisplay(!display)}><BsPencilFill/> </Button>
                    </InputGroupAddon>
                </InputGroup>
           
        );
    }
    return (<div data-testid = "displayfalse" onClick={()=>setDisplay(!display)}>{tripName}</div>); 
}


export function checkInput(value){
   var val = value.toString();
   if(val.length>0){
       return val;
   }
   return "My Trip";
}
