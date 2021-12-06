import React from 'react';
import { Map as LeafletMap, Polyline, TileLayer, LayersControl } from 'react-leaflet';
import Marker from './Marker';
import { latLngToPlace } from '../../../utils/transformers';
import { DEFAULT_STARTING_PLACE } from '../../../utils/constants';
import 'leaflet/dist/leaflet.css';
import ReactDOM from 'react-dom';

const MAP_BOUNDS = [[-90, -180], [90, 180]];
const MAP_LAYER_ATTRIBUTION = "&copy; <a href=&quot;http://osm.org/copyright&quot;>OpenStreetMap</a> contributors";
const MAP_LAYER_URL = "https://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png";
const MAP_MIN_ZOOM = 1;
const MAP_MAX_ZOOM = 19;
const MAP_LAYERS = [
    {
      selected: true,
      name: "OpenStreetMap.Mapnik",
      attribution: "&amp;copy <a href=&quot;http://osm.org/copyright&quot;>OpenStreetMap</a> contributors",
      url: "https://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png",
    },
     {
      selected: false,
      name: "Stadia.OSMBright",
      attribution: '&copy; <a href="https://stadiamaps.com/">Stadia Maps</a>, &copy; <a href="https://openmaptiles.org/">OpenMapTiles</a> &copy; <a href="http://openstreetmap.org">OpenStreetMap</a> contributors',
      url: "https://tiles.stadiamaps.com/tiles/osm_bright/{z}/{x}/{y}{r}.png",
    },
    {
      selected: false,
      name: "Esri.WorldImagery",
      attribution: "Tiles &copy; Esri &mdash; Source: Esri, i-cubed, USDA, USGS, AEX, GeoEye, Getmapping, Aerogrid, IGN, IGP, UPR-EGP, and the GIS User Community",
      url: "https://server.arcgisonline.com/ArcGIS/rest/services/World_Imagery/MapServer/tile/{z}/{y}/{x}",
    },
  ];

  /*export function MapLayers() {
    return (
      <LeafletMap 
        center={placeToLatLng(DEFAULT_STARTING_PLACE)} 
        zoom={15}
        minZoom={1}
        maxZoom={19}
      >
        <LayersControl position="topright">
          {MAP_LAYERS.map(
            layerData => renderMapLayer(layerData)
          )}
        </LayersControl>
      </LeafletMap>
    );
  }

  function renderMapLayer(layerData) {
          return (
      <LayersControl.BaseLayer checked={layerData.selected} name={layerData.name}>
        <TileLayer {...layerData} />
      </LayersControl.BaseLayer>
    );
  } */
  function placeToLatLng(place) {
    return place ? { lat: parseFloat(place.latitude), lng: parseFloat(place.longitude) } : null;
  }

  
export default function Map(props) {
    function handleMapClick(mapClickInfo) {
        props.placeActions.append(latLngToPlace(mapClickInfo.latlng));
    }

    return (
        <LeafletMap
            className="mapStyle"
            boxZoom={false}
            useFlyTo={true}
            zoom={15}
            minZoom={MAP_MIN_ZOOM}
            maxZoom={MAP_MAX_ZOOM}
            maxBounds={MAP_BOUNDS}
            center={placeToLatLng(DEFAULT_STARTING_PLACE)}
            onClick={handleMapClick}
            data-testid="Map"
        > 
        <TripLines places={props.places} />
        <PlaceMarker places={props.places} selectedIndex={props.selectedIndex} />
          <LayersControl position="topright">
            {MAP_LAYERS.map(
              layerData => renderMapLayer(props, layerData)
            )}
          </LayersControl>
        </LeafletMap>
    ); 
}

function renderMapLayer(props, layerData) {
  return (
    <LayersControl.BaseLayer checked={layerData.selected} name={layerData.name}>
    <TileLayer {...layerData} />
    </LayersControl.BaseLayer>
);
}

function TripLines(props) {
    const pathData = computePaths(props.places);
    return pathData.map((path, index) =>
        <Polyline
            key={`${JSON.stringify(path)}-${index}`}
            positions={path}
        />
    );
}

function computePaths(places) {
    if (places.length < 2) {
        return [];
    }

    const pathPointPairs = [];
    for (let i = 0; i < places.length; i++) {
        const fromPlace = places[i];
        const toPlace = places[(i+1) % places.length];
        pathPointPairs.push([fromPlace, toPlace]);
    }
    return pathPointPairs;
}

function PlaceMarker({places, selectedIndex}) {
    if (selectedIndex === -1) {
        return null;
    }
    return <Marker place={places[selectedIndex]} />;
}