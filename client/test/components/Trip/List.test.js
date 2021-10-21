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
        render(<List/>)
    });

    //still need a fake request to test line 16-25

    it('renders an Add button', async ()=> {
        addButton = screen.findByRole('button', { name: /Add/i });
        await waitFor(() => {
            expect(screen.findByText(/Name:/i));
            expect(screen.findByText(/Country:/i));
            expect(screen.findByText(/Latitude:/i));
            expect(screen.findByText(/Latitude:/i));
             
         });
        
    });


   
             
    

    it('contain not result found', async () => {
        screen.findByText(/No results found /i);
             
    });

  
});