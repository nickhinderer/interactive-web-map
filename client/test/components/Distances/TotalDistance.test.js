import React from 'react';
import { render, screen } from '@testing-library/react';
import { beforeEach, describe, expect, it } from '@jest/globals';
import TotalDistance, { Row, Sum, returnTotal } from '../../../src/components/Distances/TotalDistance';

describe('TotalDistance', () =>{
    beforeEach(() => {
        render(<TotalDistance distances={[1,2,3]} err={true}/>)
        //Fix TotalDistance class
    });

    it('sum returns correct total', () =>{
        //Add tests later
        const distances = [1, 2, -1];
        const total = Sum(distances);
        expect(total).toEqual(2);
    });

});