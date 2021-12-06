import React from 'react';
import { render, screen,fireEvent,waitFor } from '@testing-library/react';
import { beforeEach, describe, expect, it, jest } from '@jest/globals';
import TripName,{checkInput} from '../../../src/components/Trip/TripName';
import user from '@testing-library/user-event';
import { Button } from 'reactstrap';

describe('TripName', () => {
    const display = false;

    beforeEach(() => {
        render(<TripName display={display} />);
    });

    it('test checkInput fucntion with valid input',  () => {
        const result  = checkInput("check");
        expect (result).toEqual("check");
    });

    it('test checkInput fucntion with invalid input',  () => {
        const result  = checkInput("");
        expect (result).toEqual("My Trip");
    });

    it('contain BsPencilFill icon ',() => {
        const icon = screen.getByTestId('displayfalse');
        expect(icon).toBeDefined();
    });

   

    it('test input and update name of the trip ',async() => {
        render(<TripName display={true} />);
        const inputBox = screen.queryByPlaceholderText(/Modify your Trip Name here/i)
        user.type(inputBox,"newTrip");
        
        screen.getByRole('button').click()
        
        waitFor(() => {
            //user.click(button);
            const result = screen.getByTestId(/displayfalse/i)
            expect(result).toContain('newtrip');
        });

    });

   

    
});
