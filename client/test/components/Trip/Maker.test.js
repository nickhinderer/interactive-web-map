import React from 'react';
import { render, screen, waitFor } from '@testing-library/react';
import '@testing-library/jest-dom';
import user from '@testing-library/user-event';
import { beforeEach, describe, it, jest } from '@jest/globals';

import Marker from '../../../src/components/Trip/Map/Marker';

describe('Marker', () =>{
    beforeEach(() =>{
        render(<Marker/>)
    });
    it('contains a search LeafletMarker', async() =>{
        expect(screen.findByRole('LeafletMarker')).toBeDefined();
    });
    it('contain Choose Other Popup', async() => {
        expect(screen.findByRole('Popup')).toBeDefined();
             
    });
});
    