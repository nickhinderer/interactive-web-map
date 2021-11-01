import React from 'react';
import { act, render, screen, waitFor,fireEvent,userEvent  } from '@testing-library/react';
import user from '@testing-library/user-event';
import { VALID_FIND_RESPONSE } from '../../sharedMocks';
import { beforeEach, describe, expect, it} from '@jest/globals';
import FindModal, { FindInput } from '../../../src/components/Trip/Find/FindModal';

describe('FindModal', () =>{
    const places=[];
    const selectedIndex = 1;
    const validUrl = 'http://localhost:8000';
    const serverSettings = { 'serverUrl': validUrl, 'serverConfig': null};
   
    let findButton;
    let inputBox;
    let searchButtom;
    beforeEach(() =>{
        fetch.resetMocks();
        fetch.mockResponse(VALID_FIND_RESPONSE);
        render(<FindModal selectedIndex={selectedIndex} placeActions={jest.fn()} serverSettings={serverSettings}/>)
    });

    
    
    it('display inputbox and button', async () => {
        screen.findByRole("ModalHeader",{name:/Find Places/i});
        screen.findByRole("input");
	    screen.findByRole('button', { name: /Search/i });     
        
	});


    it('user able to type text', async () => {
        
	    inputBox = screen.findByRole("input");
        user.type(inputBox, "VALID_FIND_RESPONSE");

        await waitFor(() => {
           expect(screen.findByPlaceholderText('VALID_FIND_RESPONSE'));
            
        });

	});

    it('renders an input box', () =>{
        const display = false;
        const match = "";
        const setDisplay = (bool) => {display = bool};
        const setMatch = (val) => {match = val};
        const input = FindInput(setDisplay, setMatch);
        expect(input).toBeDefined();
    });

    //need test for lines 28, 40-42
});