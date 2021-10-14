import React from 'react';
import { Button, Col, Container, Input, Modal, ModalBody, ModalFooter, ModalHeader, Row } from 'reactstrap';
import { useServerInputValidation } from '../../hooks/useServerInputValidation';
import ListServer from './ListServer';
import {sendAPIRequest} from '../../utils/restfulAPI';
import  { useCallback,useEffect,useState } from 'react';

export default function ServerSettings(props) {
    const [serverInput, setServerInput, config, validServer, resetModal]
        = useServerInputValidation(props.serverSettings.serverUrl, props.toggleOpen);

        function closeModalWithoutSaving() {
            resetModal(props.serverSettings.serverUrl);
        }

    return (
        <Modal isOpen={props.isOpen} toggle={closeModalWithoutSaving}>
            <Header toggleOpen={closeModalWithoutSaving} />
            <Body
                serverInput={serverInput}
                setServerInput={setServerInput}
                serverSettings={props.serverSettings}
                serverName={getCurrentServerName(config, props.serverSettings)}
                validServer={validServer}
            />
            <Footer
                config={config}
                serverInput={serverInput}
                validServer={validServer}
                resetModal={resetModal}
                closeModalWithoutSaving={closeModalWithoutSaving}
                processServerConfigSuccess={props.processServerConfigSuccess}
            />
        </Modal>
    );
}

function getCurrentServerName(config, serverSettings) {
    if (config) {
        return config.serverName;
    }
    else if (serverSettings.serverConfig) {
        return serverSettings.serverConfig.serverName;
    }
    return "";
}

function Header(props) {
    return (
        <ModalHeader className="ml-2" toggle={props.toggleOpen}>
            Server Connection
        </ModalHeader>
    );
}

function Body(props) {
    const [displayConfig,setConfig] = useState('"Config"');
    const [displayFind,setFind] = useState('"Find"');
    const [displayDistances,setDistances] = useState('"Distances"');
    const [displayTour,setTour] = useState('"Tour"');
    const [displayType,setType] = useState('"Type"');
    const [displayWhere,setWhere] = useState('"Where"');
    const [displayUnits,setUnits] = useState('"Units"');
    const [displayTitle,setTitle] = useState('"Title"');
 




    const urlInput =
        <Input
            value={props.serverInput}
            placeholder={props.serverSettings.serverUrl}
            onChange={(e) => { props.setServerInput(e.target.value);}}
            valid={props.validServer}
            invalid={!props.validServer}
        />;

        const sendRequest = useCallback(async(newURL) => {
        
            const configResponse = await sendAPIRequest({ requestType: "config"}, newURL);
            var features= configResponse.features;
            console.log(features);
           
            features[0]? setConfig('"Config"'):setConfig("");
            features[1]? setFind('"Find"'):setFind("");
            features[2]? setDistances('"Distances"'):setDistances("");
            features[3]? setTour('"Tour"'):setDistances("");
           /* uncommon it when more features avaialbe on other server;
            features[4]? setType('"Type"'):setDistances("");
            features[5]? setWhere('"Where"'):setDistances("");
            features[6]? setUnits('"Units"'):setDistances("");
            features[7]? setTitle('"Title"'):setDistances("");*/
            
          },[])
   
          
    function handleChange(newURL){ 
        props.setServerInput(newURL);
        sendRequest(newURL);
            
    }

        
    return (
        <ModalBody >
            <Container >
                <SettingsRow label="Name" value={props.serverName} />
                <SettingsRow label="URL"  value={urlInput} />
                <SettingsRow label="Other Server"   value={<ListServer onChange={handleChange} />} />
                <SettingsRow label="Available Feature"   value={<div>{displayConfig} {displayFind} {displayDistances}</div>} />

            </Container>
        </ModalBody>
    );
}

function SettingsRow({label, value}) {
    return (
        <Row className="my-2 vertical-center">
            <Col xs={3}>
                {label}:
            </Col>
            <Col xs={9}>
                {value}
            </Col>
        </Row>
    );
}

function Footer(props) {
    return (
        <ModalFooter>
            <Button color="secondary" onClick={props.closeModalWithoutSaving}>Cancel</Button>
            <Button color="primary" onClick={() => {
                props.processServerConfigSuccess(props.config, props.serverInput);
                props.resetModal(props.serverInput);
                
            }}
                disabled={!props.validServer}
            >
                Save
            </Button>
        </ModalFooter>
    );
}
