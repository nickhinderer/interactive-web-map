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
    const [displayConfig,setConfig] = useState("Config");
    const [displayFind,setFind] = useState("Find");
    const [displayDistances,setDistances] = useState("");




    const urlInput =
        <Input
            value={props.serverInput}
            placeholder={props.serverSettings.serverUrl}
            onChange={(e) => { props.setServerInput(e.target.value);}}
            valid={props.validServer}
            invalid={!props.validServer}
        />;

        const sendFindRequest = useCallback(async(newURL) => {
        
            const findResponse = await sendAPIRequest({ requestType: "find", match:"abc", limit:100 }, newURL);
            findResponse? setFind("Find"):setFind("");
            const configResponse = await sendAPIRequest({ requestType: "config"}, newURL);
            configResponse? setConfig("Config"):setConfig("");
            const distancesResponse = await sendAPIRequest({ requestType: "distances",places: [{"name":"place1", "latitude":  "40.6",  "longitude": "-105.1"},{"name": "place2", "latitude":  "-33.9", "longitude": "151.2"},{"name": "place3", "latitude":  "-57.9", "longitude": "175.2"}], earthRadius   : 6371.0}, newURL);
            console.log(distancesResponse);
            distancesResponse? setDistances("Distances"):setDistances("");
          },[])
    
          
    function handleChange(newURL){ 
        props.setServerInput(newURL);
        sendFindRequest(newURL);
            
    }

        
    return (
        <ModalBody>
            <Container>
                <SettingsRow label="Name" value={props.serverName} />
                <SettingsRow label="URL"  value={urlInput} />
                <SettingsRow label="Other Server"   value={<ListServer onChange={handleChange} onClick={()=>checkConfig()}/>} />
                <SettingsRow label="Available Feature"  value={<div>"{ displayConfig}"    "{displayFind}"    "{displayDistances}"</div>} />

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
