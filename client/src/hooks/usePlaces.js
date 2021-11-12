import { useState } from 'react';
import { placeToLatLng } from '../utils/transformers';
import { reverseGeocode } from '../utils/reverseGeocode';
import { LOG } from '../utils/constants';
import { isJsonResponseValid } from '../utils/restfulAPI';
import * as tripFileSchema from '../../schemas/TripFile';
import Papa from 'papaparse';

export function usePlaces() {
    const [places, setPlaces] = useState([]);
    const [selectedIndex, setSelectedIndex] = useState(-1);

    const context = { places, setPlaces, selectedIndex, setSelectedIndex };

    const placeActions = {
        append: async (place) => append(place, context),
        update: (newPlaces)=>setPlaces(newPlaces),
        moveToHome: async () => moveToHome(context),
        removeAtIndex: (index) => removeAtIndex(index, context),
        removeAll: () => removeAll(context),
        selectIndex: (index) => selectIndex(index, context),
        readFile: (fileName, fileObject) => readFile(fileName, fileObject, context),
        buildTripJSON: () => buildTripJSON(context),
        downloadFile: (fullFileName, mimeType, fileText) => downloadFile(fullFileName, mimeType, fileText)
    };

    return {places, selectedIndex, placeActions}; 
}

async function append(place, context) {
    
    const { places, setPlaces, setSelectedIndex } = context;

    const newPlaces = [...places];

    const fullPlace = await reverseGeocode(placeToLatLng(place));
    newPlaces.push(fullPlace);

    setPlaces(newPlaces);
    setSelectedIndex(newPlaces.length - 1);
}

async function moveToHome(context) {
    if (navigator.geolocation) {
      navigator.geolocation.getCurrentPosition(onSuccess, onError);
    } // Prompt user to accept browser geolocation access
    
    function onSuccess({coords}) {
      const place = {latitude: coords.latitude, longitude: coords.longitude};
      append(place, context);
  
      LOG.info(`The user is located at ${JSON.stringify(place)}.`);
    }
  
    function onError(error) {
      console.log(error.message);
    }
  }

function removeAtIndex(index, context) {
    const { places, setPlaces, selectedIndex, setSelectedIndex } = context;

    if (index < 0 || index >= places.length) {
        LOG.error(`Attempted to remove index ${index} in places list of size ${places.length}.`);
        return;
    }
    const newPlaces = places.filter((place, i) => index !== i);
    setPlaces(newPlaces);

    if (newPlaces.length === 0) {
        setSelectedIndex(-1);
    } else if (selectedIndex >= index && selectedIndex !== 0) {
        setSelectedIndex(selectedIndex - 1);
    }
}

function removeAll(context) {
    const { setPlaces, setSelectedIndex } = context;
    
    setPlaces([]);
    setSelectedIndex(-1);
}

function selectIndex(index, context) {
    const { places, setSelectedIndex } = context;

    if (index < -1 || index >= places.length) {
        LOG.error(`Attempted to select index ${index} in places list of size ${places.length}.`);
        setSelectedIndex(-1);
        return;
    }
    setSelectedIndex(index);
}

function readFile(fileName, fileObject, context) {
  const reader = new FileReader();
  reader.readAsText(fileObject, "UTF-8");
  reader.onload = event => {
    const file = { name: fileName, text: event.target.result };

    parseFile(file, context);

  };
  
  function parseFile(file, context) {
    const { setPlaces, setSelectedIndex } = context;
    var newPlaces = [];

    const extension = file.name.split('.').pop();
    if (extension === "json") { 
      if (isJsonResponseValid(JSON.parse(file.text), tripFileSchema)) {
        console.log("Building trip from JSON file.");
        
        var jsonList = JSON.parse(file.text);

        for (var i = 0; i < jsonList.places.length; i++) {
          const latLng = placeToLatLng(jsonList.places[i]);
          newPlaces.push(latLng);
        }

        setPlaces(newPlaces);
        setSelectedIndex(newPlaces.length - 1);
      }
    } else if (extension === "csv") {
      console.log("Building trip from CSV file.");

      var indPlace = {};   
      var csvList = Papa.parse(file.text);
      
      var numItems = csvList.data[0].length;
      var items = csvList.data[0];
      for (var i = 1; i < csvList.data.length; i++) {

        for (var j = 0; j < numItems; j++) {
          indPlace[items[j]] = csvList.data[i][j];
        }

        const latLng = placeToLatLng(indPlace);
        newPlaces.push(latLng);
        indPlace = {};
      }
      
      setPlaces(newPlaces);
      setSelectedIndex(newPlaces.length - 1); 
    }
  }
}

/* Functions for Save File */
function downloadFile(fullFileName, mimeType, fileText) {
  const file = new Blob([fileText], { type: mimeType });
  const link = document.createElement("a");
  const url = URL.createObjectURL(file);

  link.href = url;
  link.download = fullFileName;

  document.body.appendChild(link);
  
  link.click();
  
  setTimeout(function() {
    document.body.removeChild(link);
    window.URL.revokeObjectURL(url);
  }, 0)
}

function buildTripJSON(context) {
  const { places, selectedIndex } = context;
  
  const tripJson = {
    places: []
  };
  var placesJson = tripJson.places;
  places.map((place) =>
    placesJson.push(
      { "name": place.name,
        "latitude": place.lat,
        "longitude": place.lng 
      }
    )
  );
  
  // Turn the object into a string with a spacing of 2 for readability.
  return JSON.stringify(tripJson, null, 2);
}
