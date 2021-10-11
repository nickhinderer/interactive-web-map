import React from 'react';
import { render, screen } from '@testing-library/react';
import user from '@testing-library/user-event';
import { beforeEach, describe, expect, it, test } from '@jest/globals';
import FindModal from '../../../src/components/Trip/Find/FindModal';

describe('FindModal', () =>{
    beforeEach(() =>{
        render(<FindModal/>)
    });

    it('contains a search button image', () =>{
        expect(screen.getByRole('img', { name: /search/i })).toBeDefined();
    });

    it('contains a search button', () =>{
        expect(screen.getByRole('button', { toggle: false })).toBeDefined();
    });

    it('toggles modal when clicked', () =>{
        const searchButton = screen.getByRole('img', { name: /search/i });
        //Add correct testing for modal here

    });

    //Add testing for input box here

});