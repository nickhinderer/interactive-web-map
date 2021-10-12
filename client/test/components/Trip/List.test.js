import React from 'react';
import { render, screen } from '@testing-library/react';
import user from '@testing-library/user-event';
import { beforeEach, describe, expect, it, test } from '@jest/globals';
import List from '../../../src/components/Trip/Find/List';

describe('List', () =>{
   
    beforeEach(() =>{
        render(<List/>)
    });

    it('renders an Add button', () => {
        expect(screen.findByText(/Add/i)).toBeDefined();
    });
    

});