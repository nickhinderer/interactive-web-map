/* 
Approach for FindModal.js

Renders input box in the Modal (keeps it contained external to the main page)
Renders result (potentially use list component)
- Progressive Disclosure
Getting data for Planner
- callback function to get parent
- Button - use ReactStract 
- Good for longevity
LOOK INTO "useState" as a form of managing places
*/

import React, { useState } from 'react';
import { Button, Modal, ModalHeader, ModalBody, ModalFooter } from 'reactstrap';
import { ReactComponent as Search } from './static/images/geo.svg'

const FindModal = () => {
    const [modal, setModal] = useState(false);
    const toggle = () => setModal(!modal);

    return (
        <div>
            <Button onClick={toggle}><Search />Search</Button>
            <Modal isOpen={modal} toggle={toggle}>
                <ModalHeader>Search</ModalHeader>
                <ModalBody>Search Bar Goes Here</ModalBody>
                <ModalFooter>
                    <Button onclick={toggle}>Done</Button>
                </ModalFooter>
            </Modal>
        </div>
    );
}

export default FindModal;