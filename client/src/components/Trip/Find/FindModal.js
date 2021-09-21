/* 
Approach for FindModal.js

Renders input box in the Modal (keeps it contained external to the main page)
Renders result (potentially use list component)
- Progressive Disclosure
Getting data for Planner
- callback function to get parent
- Button - use ReactStract 
LOOK INTO "useState" as a form of managing places
Questions:
    What is the setModal() component doing?
*/
import React from 'react';
import React, { useState } from 'react';
import { Button, Modal, ModalHeader, ModalBody, ModalFooter } from 'reactstrap';

const FindModal = (props) => {
    const {
        searchButton,
        findModal
    } = props;

    const [modal, setModal] = useState(false);
    const toggle = () => setModal(!modal);

    return (
        <div>
            <Button color="secondary" onClick={toggle}>{searchButton}</Button>
            <Modal isOpen={modal} toggle={toggle} className={findModal}>
                <ModalHeader toggle={toggle}>Find Places</ModalHeader>
                <ModalBody>
                    TODO: Search box here
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


