function initMap() {
  const CONFIGURATION = {
    "ctaTitle": "Crea evento",
    "mapOptions": {"center":{"lat":37.4221,"lng":-122.0841},"fullscreenControl":true,"mapTypeControl":false,"streetViewControl":false,"zoom":11,"zoomControl":true,"maxZoom":22},
    "mapsApiKey": "AIzaSyBjFSumfyTkGsJhViAvtmi8M6_ZrYYwz6o",
    "capabilities": {"addressAutocompleteControl":true,"mapDisplayControl":true,"ctaControl":true}
  };
  const componentForm = [
    'address',
    'locality'
  ];
  const map = new google.maps.Map(document.getElementById("map"), {
    zoom: CONFIGURATION.mapOptions.zoom,
    center: { lat: 37.4221, lng: -122.0841 },
    mapTypeControl: false,
    fullscreenControl: CONFIGURATION.mapOptions.fullscreenControl,
    zoomControl: CONFIGURATION.mapOptions.zoomControl,
    streetViewControl: CONFIGURATION.mapOptions.streetViewControl
  });
  const marker = new google.maps.Marker({map: map, draggable: false});
  const autocompleteInput = document.getElementById('address');
    autocomplete.addListener('place_changed', function () {
    marker.setVisible(false);
    const place = autocomplete.getPlace();
    if (!place.geometry) {
      // User entered the name of a Place that was not suggested and
      // pressed the Enter key, or the Place Details request failed.
      window.alert('Hai sbagliato a scrivere: \'' + place.name + '\'');
      return;
    }
    renderAddress(place);
    fillInAddress(place);
  });

  function fillInAddress(place) {  // optional parameter
    const addressNameFormat = {
      'street_number': 'short_name',
      'locality': 'long_name',
    };
    const getAddressComp = function (type) {
      for (const component of place.address_components) {
        if (component.types[0] === type) {
          return component[addressNameFormat[type]];
        }
      }
      return '';
    };
    document.getElementById('address').value = getAddressComp('street_number') 
    for (const component of componentForm) {
      // Location field is handled separately above as it has different logic.
      if (component !== 'address') {
        document.getElementById(component).value = getAddressComp(component);
      }
    }
  }

  function renderAddress(place) {
    map.setCenter(place.geometry.location);
    marker.setPosition(place.geometry.location);
    marker.setVisible(true);
  }
}