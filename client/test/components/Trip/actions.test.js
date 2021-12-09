import React from 'react';
import '@testing-library/jest-dom';
import { beforeEach, describe, expect, it, jest } from '@jest/globals';
import { render, screen, fireEvent } from '@testing-library/react';
import { ItineraryActionsDropdown } from '../../../src/components/Trip/Itinerary/actions.js';

describe('Dropdown', () => {
    
    const selectedIndex = 1;
    const validUrl = 'http://localhost:8000';
    const serverSettings = { 'serverUrl': validUrl, 'serverConfig': null};
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
        render(<ItineraryActionsDropdown selectedIndex={selectedIndex} placeActions={placeActions} serverSettings={serverSettings} />)
    });

    //Testing for Dropdown related events
    it('contains a search Dropdown', () => {
        expect(screen.findByRole('Dropdown')).toBeDefined();
    });

    it('Hamburger button toggle', () => {
        const dots = screen.findByTestId('row-toggle');
        expect(dots).toBeDefined();
    });
    
    it('Contains delete button for place in Itinerary', () => {
        const trash = screen.findByTestId('delete-button');
        expect(trash).toBeDefined();
    });

    // Testing for Home 
    it('contains Home icon', async () => {
        const icon = screen.findByTestId('home-icon');
        expect(icon).toBeDefined(); 
    });
    
    it('Where Am I? Home Icon click', async () => { 
        fireEvent.click(await screen.findByTestId('home-icon')); 
        expect(screen.getByTestId('home-icon')).toBeTruthy();
    });

    // Testing for Delete All
    it('contains Delete All icon', async () => {
        const icon = screen.findByTestId('delete-all-icon');
        expect(icon).toBeDefined(); 
    });
    
    it('Delete All Icon click', async () => { 
        fireEvent.click(await screen.findByTestId('delete-all-icon')); 
        expect(screen.getByTestId('delete-all-icon')).toBeTruthy();
    });

    // Testing for Load
    it('contains Load File icon', async () => {
        const icon = screen.findByTestId('load-trip-icon');
        expect(icon).toBeDefined(); 
    });

    it('Load File Icon click', async () => { 
        fireEvent.click(await screen.findByTestId('load-trip-icon')); // could use fireEvent or user
        expect(screen.getByTestId('load-trip-icon')).toBeTruthy();
    });

    // Testing for Save
    it('contains Save File icon', async () => {
        const icon = screen.findByTestId('save-trip-icon');
        expect(icon).toBeDefined();
    });

    it('Save File Icon click', async () => { 
        fireEvent.click(await screen.findByTestId('save-trip-icon')); 
        expect(screen.getByTestId('save-trip-icon')).toBeTruthy();
    });

    // TODO: Testing for Where Is
    it('contains Where Is? icon', async () => {
        const icon = screen.findByTestId('where-is-icon');
        expect(icon).toBeDefined();
    });

    it('Where Is? Icon click', async () => { 
        fireEvent.click(await screen.findByTestId('where-is-icon')); 
        expect(screen.getByTestId('where-is-icon')).toBeTruthy();
    });
});