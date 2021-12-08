
import React, { useState } from 'react';
import { DropdownItem, DropdownMenu, DropdownToggle, UncontrolledDropdown, Button, ButtonGroup, Modal, ModalBody, ModalHeader, ModalFooter, Popover, Input, InputGroup, InputGroupAddon } from 'reactstrap';
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
    const [savePopover, setSavPopover] = useState(false);
    const [uploadPopover, setUpPopover] = useState(false);
    const [deletePopover, setDelPopover] = useState(false);
    const bgColor = '#D3D3D3';

    return (
        <ActionsDropdown {...props}>
            <DropdownItem onClick={() => moveToHome(props)} data-testid='home-icon'>
                <FaHome />
            </DropdownItem>
            <DropdownItem onClick={() => removeAll(props)} onMouseEnter={() => setDelPopover(!deletePopover)} onMouseLeave={() => setDelPopover(!deletePopover)} data-testid='delete-all-icon'>
                {deleteIcon(bgColor, deletePopover)}
            </DropdownItem>
            <DropdownItem onClick={iconClick} onMouseEnter={() => setUpPopover(!uploadPopover)} onMouseLeave={() => setUpPopover(!uploadPopover)} data-testid='load-trip-icon'>
                {uploadIcon(bgColor, uploadPopover)}
            </DropdownItem>
            <DropdownItem onClick={() => handleJSONSave(props)} onMouseEnter={() => setSavPopover(!savePopover)} onMouseLeave={() => setSavPopover(!savePopover)} data-testid='save-trip-icon'>
                {saveIcon(bgColor, savePopover)}
            </DropdownItem>
            <DropdownItem onClick={toggle} data-testid='where-is-icon'>
                <FaQuestion/>
                <RenderModal whereIcon={whereIcon} setWhereIcon={setWhereIcon} toggle={toggle} />
            </DropdownItem>
        </ActionsDropdown> 
    );
}

function deleteIcon(bgColor, deletePopover){
    return(
        <div>
            <FaTrashAlt id="del"/>
            <Popover style={{backgroundColor: bgColor}} target="del" placement="bottom" isOpen={deletePopover}> <b>Delete All</b> </Popover>
        </div>
    );
}

function uploadIcon(bgColor, uploadPopover){
    return(
        <div>
            <FaFileUpload id="up"/>
            <Popover style={{backgroundColor: bgColor}} target="up" placement="bottom" isOpen={uploadPopover}> <b>Upload</b> </Popover>
        </div>
    );
}

function saveIcon(bgColor, savePopover){
    return(
        <div>
            <FaFileDownload id="save"/>
            <Popover style={{backgroundColor: bgColor}} target="save" placement="bottom" isOpen={savePopover}> <b>Save</b> </Popover>
        </div>
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

function RenderModal(props) {
    return (
        <Modal isOpen={props.whereIcon} toggle={props.toggle} data-testid='where-is-modal'>
            <ModalHeader>
                Coordinate Search    
            </ModalHeader> 

                <ModalBody> 
                    <InputGroup>
                        <InputGroupAddon addonType="append"> Coordinates </InputGroupAddon>
                        <Input placeholder={"latitude, longitude"} />
                    </InputGroup>
                </ModalBody>

            <ModalFooter> 
                <Button color="primary" onClick={props.toggle}> <img src={check} /> </Button>
                <Button color="danger" onClick={props.toggle}> <img src={x} /> </Button>
            </ModalFooter>
        </Modal>
    );
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