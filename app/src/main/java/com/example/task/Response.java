package com.example.task;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class Response {
    @SerializedName("venues")
    @Expose
    public ArrayList<VenuesGson> venuesGson;

    public ArrayList<VenuesGson> getVenuesGson() {
        return venuesGson;
    }

    public void setVenuesGson(ArrayList<VenuesGson> venuesGson) {
        this.venuesGson = venuesGson;
    }
}
