package com.example.applicazionevera;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.os.Bundle;
import android.text.format.DateFormat;

import java.util.Date;

public class LocationManager extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location_manager);

        Location location = null;

        String provider = location.getProvider();
        String data= DateFormat.format("dd/MM/yyyy", location.getTime()).toString();
        String longitude = "Longitudine: " + location.getLongitude();
        String latitude = "Latitudine: " + location.getLatitude();
        String altitudine = "Altitudine: " + location.getAltitude();

        LocationManager mlocManager = (LocationManager)getSystemService(Context.LOCATION_SERVICE);
//creazione istanza della mia classe che implementa il LocationListener
        LocationListener mlocListener = new LocationListener();
//in base al fatto che il gps sia attivo o meno
//non significa però che abbia preso il segnale...)
        if(mlocManager.isProviderEnabled(LocationManager.GPS_PROVIDER))
            mlocManager.requestLocationUpdates(LocationManager.GPS_PROVIDER,
                    MIN_TIME_BW_UPDATES, MIN_DISTANCE_CHANGE_FOR_UPDATES, mlocListener);
//in base al fatto che il gps via rete sia accessibile
        else if(mlocManager.isProviderEnabled(LocationManager.NETWORK_PROVIDER))
            mlocManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, UPDATES,
                    MIN_DISTANCE_CHANGE_FOR_UPDATES, mlocListener);
    }

    private LocationListener locationListener = new LocationListener() {
        @Override
        public void onStatusChanged (String provider,int status, Bundle extras) {
        }
        @Override
        public void onProviderEnabled (String provider) {
            // attivo GPS su dispositivo
        }
        @Override
        public void onProviderDisabled (String provider) {
            // disattivo GPS su dispositivo
        }
        @Override
        public void onLocationChanged (Location location) {
            Date timestamp = new Date(location.getTime());
            double latitude = location.getLatitude();
            double longitude = location.getLongitude();
            new AddressSolver().execute(location);
        }
    };
}