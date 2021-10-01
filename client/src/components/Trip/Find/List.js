import React from 'react';
import  { useCallback,useEffect,useState } from 'react';
import { getOriginalServerUrl, sendAPIRequest }  from '../../../utils/restfulAPI';
import bookmark from '../../../static/images/bookmark-plus-fill.svg';
import { Button } from 'reactstrap';
import Itinerary from '../../../components/Trip/Itinerary/Itinerary.js';


//what is left?
    //convert(could use .map) match to string and  pass it  (use props.match could get match variable)
    // setup the details of the Places ( the return found place from server);
    //create a new file(function) for select place
    //create a new file(function) for add place

export default function display(props) {

    // this part for sending the findrequest.
    const [places,setPlaces] = useState([]);
    const sendFindRequest = useCallback(async() => {
        
        const serverUrl = getOriginalServerUrl();
        const findResponse = await sendAPIRequest({ requestType: "find", match:props.match, limit: 10 }, serverUrl);
        setPlaces(findResponse.places);
        console.log(findResponse);
        
      },[])

      useEffect(() => {
        sendFindRequest()
      }, [sendFindRequest])


// this part for render the found place.
    return(
        <div className='List'>
            {places.map((place) => (
                <div key={place.index}>
                    <ul><Button color='primary' onClick={AddToTrip}><img src={bookmark} alt='add'/> Add </Button>
                    <div><b>Name:</b> {place.name}</div>
                    <div><b>Latitude:</b> {place.latitude}</div>
                    <div><b>Longitude:</b> {place.longitude}</div>
                    <div><b>Country:</b> {place.country}</div></ul>
                </div>
            ))}
        </div>
    );
}

function AddToTrip(props){
    //Add place to intinerary?
    //Maybe use TableRow
    //Maybe use placeToLatLng or latLngToPlace
    //Could UsePlaces class help?
}