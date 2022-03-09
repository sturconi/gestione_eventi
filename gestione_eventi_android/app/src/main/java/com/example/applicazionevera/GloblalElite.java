package com.example.applicazionevera;

import android.Manifest;
import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationManager;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;

import retrofit2.Retrofit;
import retrofit2.converter.scalars.ScalarsConverterFactory;

public class GloblalElite extends Application implements android.location.LocationListener {

    private boolean switchButtonSport;
    private boolean switchButtonInt;
    private boolean switchButtonCul;
    private boolean switchButtonServ;
    private final static String salva = "textdata";
    public final static String notificaSport = "notificaSport";
    public final static String notificaCul = "notificaCul";
    public final static String notificaInt = "notificaInt";
    public final static String notificaServ = "notificaServ";
    public final static String REGIURL = "http://10.0.2.2:8080/";


    private LocationManager locationManager = null;
    private static int MIN_TIME_BW_UPDATES = 1;
    private static int MIN_DIST_BW_UPDATES = 200;

    private Location position;

    Retrofit retrofit = null;

    public GloblalElite() {
        retrofit = new Retrofit.Builder()
                .baseUrl(REGIURL)
                .addConverterFactory(ScalarsConverterFactory.create())
                .build();
    }

    public void save(Boolean switchButton, String notifica) {
        SharedPreferences Switch = getSharedPreferences(notifica, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = Switch.edit();

        editor.putBoolean(notifica, switchButton);
        editor.commit();

//        update(switchButton, notifica);
    }

    public Boolean update(String notifica) {
        SharedPreferences Switch = getSharedPreferences(notifica, Context.MODE_PRIVATE);
        return Switch.getBoolean(notifica, false);
    }


    public void startLocation() {
        locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED &&
                ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            return;
        }
        if(locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER))
            locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, MIN_TIME_BW_UPDATES, MIN_DIST_BW_UPDATES, this);
        if(locationManager.isProviderEnabled(LocationManager.NETWORK_PROVIDER))
            locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, MIN_TIME_BW_UPDATES, MIN_DIST_BW_UPDATES, this);
    }

    @Override
    public void onLocationChanged(@NonNull Location location) {
        position = location;
    }

}