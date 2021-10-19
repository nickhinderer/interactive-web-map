import React from 'react';
import { render, screen, waitFor } from '@testing-library/react';
import '@testing-library/jest-dom';
import user from '@testing-library/user-event';
import { beforeEach, describe, it, jest } from '@jest/globals';

import ListServer from '../../../src/components/Margins/ListServer';

describe('ListServer', () =>{
    beforeEach(() =>{
        render(<ListServer/>)
    });
    it('contains a search Dropdown', () =>{
        expect(screen.findByRole('Dropdown')).toBeDefined();
    });
    it('contain Choose Other Server', async () => {
        screen.findByText(/Choose Other Server/i);
             
    });
});
    