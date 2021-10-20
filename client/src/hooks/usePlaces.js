import { useState } from 'react';
import { placeToLatLng } from '../utils/transformers';
import { reverseGeocode } from '../utils/reverseGeocode';
import { LOG } from '../utils/constants';

export function usePlaces() {
    const [places, setPlaces] = useState([]);
    const [selectedIndex, setSelectedIndex] = useState(-1);

    const context = { places, setPlaces, selectedIndex, setSelectedIndex };

    const placeActions = {
        append: async (place) => append(place, context),
        moveToHome: async () => moveToHome(context),
        removeAtIndex: (index) => removeAtIndex(index, context),
        removeAll: () => removeAll(context),
        selectIndex: (index) => selectIndex(index, context),
        readFile: (fileName, fileObject) => readFile(fileName, fileObject, context)
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

    const extension = file.name.split('.').pop();
    if (extension === "json") {      
      console.log("Building trip from JSON file.");

      /* 
          You might check against the TripFile schema using
          isJSONResponseValid(JSON.parse(file.text), tripFileSchema)
          This function is in the base code. Import tripFileSchema (TripFile.json schema). 
          Look at restfulAPI.js for reference.
      */
    }
  }
}