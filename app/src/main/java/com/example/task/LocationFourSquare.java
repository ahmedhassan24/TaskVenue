package com.example.task;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class LocationFourSquare implements Serializable {
    @SerializedName("address")
    String address;
    @SerializedName("lat")
    Double lat;
    @SerializedName("lng")
    Double lng;
    @SerializedName("formattedAddress")
    ArrayList<String> formattedAddress = null;

    public Double getLat() {
        return lat;
    }

    public void setLat(Double lat) {
        this.lat = lat;
    }
    public String getFormattedAddress() {
        String formattedAddressString = new String();
        for (int i=0;i<formattedAddress.size();i++) {
            if(i == formattedAddress.size()-1)
            formattedAddressString += this.formattedAddress.get(i);
            else{
            formattedAddressString += this.formattedAddress.get(i);
            formattedAddressString+= ", ";
            }
        }
        return formattedAddressString;
    }

    public Double getLng() {
        return lng;
    }

    public void setLng(Double lng) {
        this.lng = lng;
    }

    public void setFormattedAddress(ArrayList<String> formattedAddress) {
        this.formattedAddress = formattedAddress;
    }
}
