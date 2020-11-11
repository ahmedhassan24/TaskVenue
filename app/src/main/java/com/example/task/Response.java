package com.example.task;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Response implements Serializable {
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
