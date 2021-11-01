import React from 'react';
import { render, screen } from '@testing-library/react';
import { beforeEach, describe, expect, it } from '@jest/globals';
import Tour from '../../../src/components/Tour/Tour';

describe('Tour', () =>{
    beforeEach(() => {
        render(<Tour/>)
    });

    it('Tour working',() =>  {
        //add more test future
    });

});