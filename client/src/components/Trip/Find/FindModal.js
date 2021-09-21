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
import { ReactComponent as SearchImage } from '~/client/src/static/images/geo.svg';
import { ReactComponent as Exit } from '~/client/src/static/images/x.svg';

const FindModal = () => {
    const [modal, setModal] = useState(false);
    const toggle = () => setModal(!modal);

    return (
        <div>
            <Button onClick={toggle}><SearchImage />Search</Button>
            <Modal isOpen={modal} toggle={toggle}>
                <ModalHeader>Search
                    <Button onClick={toggle}><Exit /></Button>
                </ModalHeader>
                <ModalBody>Search Bar Goes Here</ModalBody>
                <ModalFooter>
                    <Button onclick={toggle}>Done</Button>
                </ModalFooter>
            </Modal>
        </div>
    );
}

export default FindModal;