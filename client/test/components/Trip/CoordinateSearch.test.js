import React from 'react';
import '@testing-library/jest-dom';
import user from '@testing-library/user-event';
import { beforeEach, describe, expect, it, jest } from '@jest/globals';
import { render, screen, fireEvent } from '@testing-library/react';
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

    it('renders a "Find by Coordinates Modal"', () => {
        expect(screen.findByRole('Modal')).toBeDefined();
    });

    it('modal toggles', () => {        
        const modal = screen.findByTestId('where-is-modal');
        expect(modal).toBeDefined();
    });

});