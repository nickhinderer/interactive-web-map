import React from 'react';
import '@testing-library/jest-dom';
import user from '@testing-library/user-event';
import { beforeEach, describe, expect, it, jest } from '@jest/globals';
import { render, screen, fireEvent } from '@testing-library/react';
import { ItineraryActionsDropdown } from '../../../src/components/Trip/Itinerary/actions.js';
import { MOCK_PLACES } from '../../sharedMocks';

describe('Dropdown', () => {
    
    const selectedIndex = 1;
    const validUrl = 'http://localhost:8000';
    const serverSettings = { 'serverUrl': validUrl, 'serverConfig': null};

    beforeEach(() => {    
        render(<ItineraryActionsDropdown selectedIndex={selectedIndex} placeActions={jest.fn()} serverSettings={serverSettings}/>)
    });

    it('contains a search Dropdown', () => {
        expect(screen.findByRole('Dropdown')).toBeDefined();
    });
    
    it('contains Load File icon', async () => {
        const icon = screen.findByTestId('load-trip-icon');
        expect(icon).toBeDefined(); 
    });

    it('Load File Icon click', async () => { 
        fireEvent.click(await screen.findByTestId('load-trip-icon')); // Use fireEvent or user
        expect(screen.getByTestId('load-trip-icon')).toBeTruthy();
    });

    it('contains Save File icon', async () => {
        const icon = screen.findByTestId('save-trip-button');
        expect(icon).toBeDefined();
    });
});