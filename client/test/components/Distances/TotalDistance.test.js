import React from 'react';
import { render, screen } from '@testing-library/react';
import { beforeEach, describe, expect, it } from '@jest/globals';
import TotalDistance, { Row, Sum, returnTotal } from '../../../src/components/Distances/TotalDistance';

describe('TotalDistance', () =>{
    beforeEach(() => {
        render(<TotalDistance distances={[1,2,3]} err={true}/>)
    });
    
    it('tests that sum returns correct total', () =>{
        const distances = [1, 2, -1];
        const total = Sum(distances);
        expect(total).toEqual(2);
    });

    it('tests totalReturn returns correct value for true err', () =>{
        const err = true;
        const distances = [-1, -3, 6];
        const response = returnTotal(distances, err);
        expect(response).toEqual('Choose at least two places to calculate distances!');
    });

    it('tests totalReturn returns correct value for false err', () =>{
        const err = false;
        const distances = [-1, -3, 6];
        const response = returnTotal(distances, err);
        expect(response).toEqual('2 Mile(s)');
    });

});