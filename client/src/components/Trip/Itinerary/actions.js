import React, { useState } from 'react';
import { DropdownItem, DropdownMenu, DropdownToggle, UncontrolledDropdown, Button, ButtonGroup, Modal, ModalBody, ModalHeader, ModalFooter } from 'reactstrap';
import { BiDotsVerticalRounded } from 'react-icons/bi';
import { FaFileUpload, FaHome, FaTrash, FaTrashAlt, FaFileDownload, FaQuestion } from 'react-icons/fa';
import check from '../../../static/images/check.svg';
import x from '../../../static/images/x.svg';

const MIME_TYPE = {
    JSON: "application/json",
    CSV: "text/csv",
    SVG: "image/svg+xml",
    KML: "application/vnd.google-earth.kml+xml"
};

const tripName = "My Trip";

export function ItineraryActionsDropdown(props) {
    const [whereIcon, setWhereIcon] = useState(false);
    const toggle = () => setWhereIcon(!whereIcon);

    return (
        <ActionsDropdown {...props}>
            <DropdownItem onClick={() => moveToHome(props)} data-testid='home-button'>
                <FaHome />
            </DropdownItem>
            <DropdownItem onClick={() => removeAll(props)} data-testid='delete-all-button'>
                <FaTrashAlt />
            </DropdownItem>
            <DropdownItem onClick={iconClick} data-testid='load-trip-icon'>
                <FaFileUpload/>
            </DropdownItem>
            <DropdownItem onClick={() => handleJSONSave(props)} data-testid='save-trip-button'>
                <FaFileDownload />
            </DropdownItem>
            <DropdownItem onClick={toggle} data-testid='where-is-icon'>
                <FaQuestion/>
                <Modal isOpen={whereIcon} toggle={toggle} data-testid='where-is-modal'>
                    <ModalBody> 
                        Here is my modal!
                    </ModalBody>
                    <ModalFooter> 
                        <Button color="primary" onClick={toggle}> <img src={check} /> </Button>
                        <Button color="danger" onClick={toggle}> <img src={x} /> </Button>
                    </ModalFooter>
                </Modal>
            </DropdownItem>
        </ActionsDropdown> 
    );
}

function moveToHome(props) { props.placeActions.moveToHome(); }
function removeAll(props) { props.placeActions.removeAll(); }

function iconClick(){
    const input = document.getElementById('file-upload');

    if (input) {
        input.click();
    }
}

function handleJSONSave(props) {
    const tripJSON = props.placeActions.buildTripJSON();
    const fileName = tripName.replace(/ /g, "_").toLowerCase();
    props.placeActions.downloadFile(fileName + ".json", MIME_TYPE.JSON, tripJSON);
}

export function PlaceActionsDropdown(props) {
    return (
        <ActionsDropdown {...props}>
            <DropdownItem onClick={() => props.placeActions.removeAtIndex(props.index)} data-testid={`delete-button-${props.index}`}>
                <FaTrash />
            </DropdownItem>
        </ActionsDropdown>
    );
}

function ActionsDropdown(props) {
    return (
        <UncontrolledDropdown direction="left" >
            <DropdownToggle tag="div" data-testid={`row-toggle-${props.index}`} >
                <BiDotsVerticalRounded size="1.5em" />
            </DropdownToggle >
            <DropdownMenu>
                <ButtonGroup >
                    {props.children}
                </ButtonGroup>
            </DropdownMenu>
        </UncontrolledDropdown>
    );
}