import React from 'react';
import { Button, Col, Container, Input, Modal, ModalBody, ModalFooter, ModalHeader, Row,Alert } from 'reactstrap';
import { useServerInputValidation } from '../../hooks/useServerInputValidation';
import ListServer from './ListServer';

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
                config={config}
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

function getFeatures(config){
    if(config){
        return config.features;
    }
    return [];
}

function Header(props) {
    return (
        <ModalHeader className="ml-2" toggle={props.toggleOpen}>
            Server Connection
        </ModalHeader>
    );
}

function Body(props) {
    const urlInput =
    
        <Input
            value={props.serverInput}
            placeholder={props.serverSettings.serverUrl}
            onChange={(e) => { props.setServerInput(e.target.value);}}
            valid={props.validServer}
            invalid={!props.validServer}
        />;
     
    function handleChange(newURL){ 
        props.setServerInput(newURL);
    }

    let display = getFeatures(props.config).join(", ");    
    return (
        <ModalBody >
            <Container >
                <SettingsRow label="Name" value={props.serverName} />
                <SettingsRow label="URL"  value={urlInput} />
                <SettingsRow label="Other Server"   value={<ListServer onChange={handleChange} />} />
                <SettingsRow label="Available Feature"   value={<div>{display}</div>} />


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
