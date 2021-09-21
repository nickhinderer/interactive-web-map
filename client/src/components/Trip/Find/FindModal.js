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

const FindModal = () => {
    const [modal, setModal] = useState(false);
    const toggle = () => setModal(!modal);

    return {
    }
}