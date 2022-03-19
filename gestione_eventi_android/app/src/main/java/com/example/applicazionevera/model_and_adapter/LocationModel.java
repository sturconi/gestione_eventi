package com.example.applicazionevera.model_and_adapter;


import com.google.gson.annotations.SerializedName;


public class LocationModel {

    @SerializedName("nomeevento")
    private String imageLocationName;
    @SerializedName("latitudine")
    private String latitude;
    @SerializedName("longitudine")
    private String longitude;


    public LocationModel(String latitude, String longitude, String imageLocationName) {
        this.imageLocationName = imageLocationName;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public String getImageLocationName() {
        return imageLocationName;
    }

    public void setImageLocationName(String imageLocationName) {
        this.imageLocationName = imageLocationName;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }
}