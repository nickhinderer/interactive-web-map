import React from 'react';
import { render, screen } from '@testing-library/react';
import user from '@testing-library/user-event';
import { beforeEach, describe, expect, it, test } from '@jest/globals';
import List from '../../../src/components/Trip/Find/List';

describe('List', () =>{
   const processServerDistancesSuccess = jest.fn()
   processServerDistancesSuccess=>Promise.resolve({data:null});
    beforeEach(() =>{
        render(<List/>)
    });

    it('renders an Add button', async ()=> {
        expect(screen.findByRole('button', { name: /Add/i })).toBeDefined();
        
    });

    //it('contains a Add button image', () =>{
        //expect(screen.getByRole('img', { name: /add/i })).toBeDefined();
    //});

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