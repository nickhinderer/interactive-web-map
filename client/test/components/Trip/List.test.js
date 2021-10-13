import React from 'react';
import { render, screen } from '@testing-library/react';
import user from '@testing-library/user-event';
import { beforeEach, describe, expect, it, test } from '@jest/globals';
import List from '../../../src/components/Trip/Find/List';

describe('List', () =>{
   
    beforeEach(() =>{
        render(<List/>)
    });

    //still need a fake request to test line 16-25

    it('renders an Add button', async ()=> {
        expect(screen.findByRole('button', { name: /Add/i })).toBeDefined();
        
    });


    it('contain expected information', async ()=> {
        screen.findByText(/Name:/i);
        screen.findByText(/Country:/i);
        screen.findByText(/Latitude:/i);
        screen.findByText(/Longitude:/i); 
    });
             
    

    it('contain not result found', async () => {
        screen.findByText(/No results found /i);
             
    });

  
});