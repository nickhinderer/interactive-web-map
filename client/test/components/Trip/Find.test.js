import React from 'react';
import { render, screen } from '@testing-library/react';
import user from '@testing-library/user-event';
import { beforeEach, describe, expect, it } from '@jest/globals';
import FindModal from '../../../src/components/Trip/Find/FindModal';

describe('FindModal', () =>{
    beforeEach(() =>{
        render(<FindModal/>)
    });

    it('contains a search button', () =>{

    });
});