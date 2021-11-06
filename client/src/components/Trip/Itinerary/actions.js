import React from 'react';
import { DropdownItem, DropdownMenu, DropdownToggle, UncontrolledDropdown, ButtonGroup } from 'reactstrap';
import { BiDotsVerticalRounded } from 'react-icons/bi';
import { FaFileUpload, FaHome, FaTrash, FaTrashAlt, FaFileDownload } from 'react-icons/fa';

const MIME_TYPE = {
    JSON: "application/json",
    CSV: "text/csv",
    SVG: "image/svg+xml",
    KML: "application/vnd.google-earth.kml+xml"
};

const tripName = "My Trip";

export function ItineraryActionsDropdown(props) {

    /*const iconClick = () => {
        const input = document.getElementById('file-upload');

        if (input) {
            input.click();
        }
    }*/

    function handleJSONSave() {
        const tripJSON = props.placeActions.buildTripJSON();
        const fileName = tripName.replace(/ /g, "_").toLowerCase();
        props.placeActions.downloadFile(fileName + ".json", MIME_TYPE.JSON, tripJSON);
    }

    function moveToHome() { props.placeActions.moveToHome(); }
    function removeAll() { props.placeActions.removeAll(); }

    return (
        <ActionsDropdown {...props}>
            <DropdownItem onClick={moveToHome} data-testid='home-button'>
                <FaHome />
            </DropdownItem>
            <DropdownItem onClick={removeAll} data-testid='delete-all-button'>
                <FaTrashAlt />
            </DropdownItem>
            <DropdownItem onClick={iconClick}>
                <FaFileUpload/>
            </DropdownItem>
            <DropdownItem onClick={handleJSONSave} data-testid='save-trip-button'>
                <FaFileDownload />
            </DropdownItem>
        </ActionsDropdown> 
    );
}

function iconClick(){
    const input = document.getElementById('file-upload');

    if (input) {
        input.click();
    }
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