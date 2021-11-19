import React from 'react';
import { render, screen, waitFor, fireEvent } from '@testing-library/react';
import '@testing-library/jest-dom';
import user from '@testing-library/user-event';
import { beforeEach, describe, it, jest } from '@jest/globals';
import { ItineraryActionsDropdown } from '../../../src/components/Trip/Itinerary/actions.js';

describe('Dropdown', () => {
    beforeEach(() => {
        render(<ItineraryActionsDropdown/>)
    });

    it('contains a search Dropdown', () => {
        expect(screen.findByRole('Dropdown')).toBeDefined();
    });
    
    it('contains Load File icon', async () => {
        const button = screen.findByTestId('load-trip-icon');
        expect(button).toBeDefined(); 
    });

    it('Load File Icon click', async () => {
        fireEvent.click(await screen.findByTestId('load-trip-icon'));
    });
});