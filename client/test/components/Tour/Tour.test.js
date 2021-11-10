import React from 'react';
import {act, render, screen,  waitFor  } from '@testing-library/react';
import { beforeEach, describe, expect, it } from '@jest/globals';
import Tour, { sendTourRequest, getNewPlaces, setNewPlaces,getTrip,ExitFooter,ApplyFooter,hanldePlaces,getSize} from '../../../src/components/Tour/Tour';
import { VALID_TOUR_RESPONSE,MOCK_NEWPLACES,INVALID_REQUEST } from '../../sharedMocks';
import user from '@testing-library/user-event';

describe('Tour', () =>{
    let hanldeClick;
    let hanldeModal;
    let open = false;
    const toggle = () => open = !open;
    const validUrl = 'http://localhost:8000';
    const places =  [{"name":"Denver",       "lat": "39.7", "lng": "-105.0", "notes":"The big city"},
                     {"name":"Boulder",      "lat": "40.0", "lng": "-105.4", "notes":"Home of CU"},
                     {"name":"Fort Collins", "lat": "40.6", "lng": "-105.1", "notes":"Home of CSU"}]
    
    const placeActions = {
        update: jest.fn(),
    };
                     
    beforeEach(() => {
        hanldeClick=jest.fn();
        hanldeModal=jest.fn();
        fetch.resetMocks();
        fetch.mockResponse(VALID_TOUR_RESPONSE);
        render(<Tour places={places} placeActions={placeActions}/>)
    });

   
  
   /*it('test Body' , async() =>  {
       const newTrip = [{"latitude": "39.7", "longitude": "-105.0", "name":"Denver"},
                        {"latitude": "40.6", "longitude": "-105.1", "name":"Fort Collins"},
                        {"latitude": "40.0", "longitude": "-105.4", "name":"Boulder"}]
                        
        const places =  [{"name":"Denver",       "lat": "39.7", "lng": "-105.0", "notes":"The big city"},
                     {"name":"Boulder",      "lat": "40.0", "lng": "-105.4", "notes":"Home of CU"},
                     {"name":"Fort Collins", "lat": "40.6", "lng": "-105.1", "notes":"Home of CSU"}]
        const newTrip =[{"lat": 39.7, "lng": -105.0, "name":"Denver",},
                        {"lat": 40.6, "lng": -105.1, "name":"Fort Collins"},
                        {"lat": 40.0, "lng": -105.4,"name":"Boulder"}]
        fetch.mockResponseOnce(VALID_TOUR_RESPONSE);
        const response = await sendTourRequest(places,validUrl);
        const Apply = screen.findByTestId('Apply');
        //user.click (Apply);
        //const footer =body.findByTestId("Apply");
    });*/

    it('Send Sucess Tour request and didn\'t find shorter trip' , async() =>  {
        //add more test future
        fetch.mockResponseOnce(VALID_TOUR_RESPONSE);
        const response= await sendTourRequest(MOCK_NEWPLACES,validUrl);
        const size = getSize();
        const newPlaces = getNewPlaces();
        expect(size).toEqual(0);
        expect(newPlaces).toEqual([]);
    });

    it('Send Sucess Tour request and find shorter trip' , async() =>  {
        //add more test future
        const places =  [{"name":"Denver",       "lat": "39.7", "lng": "-105.0", "notes":"The big city"},
                     {"name":"Boulder",      "lat": "40.0", "lng": "-105.4", "notes":"Home of CU"},
                     {"name":"Fort Collins", "lat": "40.6", "lng": "-105.1", "notes":"Home of CSU"}]
        const newTrip =[{"lat": 39.7, "lng": -105.0, "name":"Denver",},
                        {"lat": 40.6, "lng": -105.1, "name":"Fort Collins"},
                        {"lat": 40.0, "lng": -105.4,"name":"Boulder"}]
                        fetch.mockResponseOnce(VALID_TOUR_RESPONSE);
        const response = await sendTourRequest(places,validUrl);
        const size = getSize();
        const newPlaces = getNewPlaces();
        expect(size).toEqual(3);
        expect(newPlaces).toEqual(newTrip);
        
    });

    

   /* it('test  modalbody when shorter trip found' , () =>  {
        //add more test future
        const body = Body(places);
        expect( JSON.stringify(body)).toContain('A shorter trip found.');
        
    });

    it('test modalbody when shorter trip not found' , () =>  {
        //add more test future
        const body = Body(null);
        expect( JSON.stringify(body)).toContain('Current Trip is the shortest trip.');
        
    });
*/

    it('test ExitFooter' , () =>  {
        //add more test future
        const footer = ExitFooter(toggle);
        expect( JSON.stringify(footer)).toContain('Exit');
        
    });


    it('test setNewPlaces' , () =>  {
        //add more test future
       setNewPlaces(places);
       expect( getTrip()).toEqual(places);
        
    });

    it('toggles modal when clicked ', async () => {
		screen.getByRole('button', {name: /Find Shorter Trip/i}).click();
		waitFor(() => {
			expect(screen.findByTestId('modal')).toBeCalled();
           
		});
        

        
    });
   describe('Apply footer',()=>{
    it ('test Apply Fotter',async()=>{
        render (<ApplyFooter placeActions={placeActions} toggle={toggle} Toggle={hanldeModal}/>);
        const button = screen.getByText("Apply")
        user.click(button);
        waitFor(()=>{
           expect(hanldeClick).toBeCalled();
           expect(hanldeModal).toBeCalled();
        });
    });
   });

}); 
