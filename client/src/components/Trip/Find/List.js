import React from 'react';
import  { useCallback,useEffect,useState } from 'react';
import { getOriginalServerUrl, sendAPIRequest }  from '../../../utils/restfulAPI';


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
                <div className='list-preview' key={place.index}>
                    <li>Name: {place.name} Latitude: {place.latitude} Longitude: {place.longitude} Country: {place.country}</li>
                </div>
            ))}
        </div>
    )
}
    

    

   

