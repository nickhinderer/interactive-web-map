import React from 'react';
import '@testing-library/jest-dom';
import user from '@testing-library/user-event';
import { beforeEach, describe, expect, it, jest } from '@jest/globals';
import { render, screen, fireEvent, waitFor } from '@testing-library/react';
import CoordinateSearch from '../../../src/components/Trip/Itinerary/CoodinateSearch';
import { MOCK_PLACES } from '../../sharedMocks';

describe('Coordinate Search', () => {

    const placeActions = { 
        buildTripJSON: jest.fn(), 
        append: jest.fn(), 
        update: jest.fn(),                           
        moveToHome: jest.fn(), 
        removeAtIndex: jest.fn(), 
        removeAll: jest.fn(), 
        selectIndex: jest.fn(),
        readFile: jest.fn(), 
        downloadFile: jest.fn()
    }

    beforeEach(() => {
        render(<CoordinateSearch placesHook={placeActions}/>);
    });

    // Modal Testing
    it('renders a "Find by Coordinates Modal"', () => {
        expect(screen.findByRole('Modal')).toBeDefined();
    });

    it('modal toggles', () => {        
        const modal = screen.findByTestId('where-is-modal');
        expect(modal).toBeDefined();
    });

    // Inputbox Testing
    it('contains inputbox and exit button', async () => {
        screen.findByRole("ModalHeader",{name:/Coordinate Search/i});
        screen.findByRole("input");
	    screen.findByRole('button');     
    });

    it('renders an inputbox', () => {
        const input = screen.findByTestId('type-coords');
        expect(input).toBeDefined();
    });

    it('user ability to type latitude and longitude', async () => {
        let inputBox = screen.findByRole("input");
        user.type(inputBox, "VALID_FIND_RESPONSE");

        await waitFor(() => {
           expect(screen.findByPlaceholderText('VALID_FIND_RESPONSE'));
            
        });
    });

    // TODO: Add Button Testing
});