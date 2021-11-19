import React from 'react';
import { render, screen,act,fireEvent,waitFor } from '@testing-library/react';
import user from '@testing-library/user-event';
import { beforeEach, describe, expect, it, test } from '@jest/globals';
import List from '../../../src/components/Trip/Find/List';
import { VALID_FIND_RESPONSE } from '../../sharedMocks';
let addButton;
describe('List', () =>{
   
    beforeEach(() =>{
        fetch.resetMocks();
        fetch.mockResponse(VALID_FIND_RESPONSE);
        render(<List match={"Fort Gordon"} places={[{"name":"Fort Gordon Hqs Helipad Heliport", 
                            "latitude":"33.420398", "longitude":"-82.139602", "country":"United States"}]} 
                            placeActions={jest.fn()}/>)
    });

    // need to test lines 37-38, 44, 69-78
    it('contains a list', () => {
        expect(screen.findByRole('List')).toBeDefined();
    });

    it('renders buttons', async ()=> {
        expect(screen.findByTestId('Add')).toBeDefined();
    });

    it('renders list info for fort gordon', () =>{
        expect(screen.findByText(/Name: fort gordon/i)).toBeDefined();
        expect(screen.findByText(/Country: united states/i)).toBeDefined();
        expect(screen.findByText(/Latitude: 33.420398/i)).toBeDefined();
        expect(screen.findByText(/Latitude: -82.139602/i)).toBeDefined();
    });

    it('contain not result found', async () => {
        expect(screen.findByText(/No results found /i));
             
    });

  
});