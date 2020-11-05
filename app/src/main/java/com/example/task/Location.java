package com.example.task;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class Location {
    @SerializedName("lat")
    String lat;
    @SerializedName("lng")
    String lng;
    @SerializedName("formattedAddress")
    ArrayList<String> formattedAddress;

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }
    public ArrayList<String> getFormattedAddress() {
        return formattedAddress;
    }

    public String getLng() {
        return lng;
    }

    public void setLng(String lng) {
        this.lng = lng;
    }

    public void setFormattedAddress(ArrayList<String> formattedAddress) {
        this.formattedAddress = formattedAddress;
    }
}
