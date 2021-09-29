
import React, { useState } from 'react';
import { Button, Modal, ModalHeader, ModalBody, ModalFooter, InputGroupText, ListGroup, ListGroupItem } from 'reactstrap';
import { InputGroup, InputGroupAddon, Input } from 'reactstrap';
import List from './List';
import mag from '../../../static/images/geo.svg'

const FindModal = () => {
    const [modal, setModal] = useState(false);
    const toggle = () => setModal(!modal);
    const [display, setDisplay] = useState(false);
    const [match, setMatch] = useState("Address");
 
    
    return (

        <div className="searchButton">
            <Button className="mx-1" outline-color="secondary" onClick={toggle}><img src={mag} alt='search'/></Button>
            <Modal isOpen={modal} toggle={toggle}>
                <ModalHeader>Find Places</ModalHeader>
                <ModalBody>
                    <InputGroup>
                        <InputGroupAddon addonType="append">
                            <InputGroupText color="green" > Address</InputGroupText>

                        </InputGroupAddon>
                        <Input placeholder={match} onChange={e => setMatch(e.target.value)} />
                    </InputGroup>

                    

                    <Button color="primary" id="button-addon1" outline type="button" onClick={() =>setDisplay(!display)}>Search </Button>
                    <br/>
                    {display? <List match={match}/> :<div></div>}
                    

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

