package com.example.task;

import android.location.Location;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;

public class VenuesGson implements Serializable {
    @SerializedName("name")
    String name;
    @SerializedName("location")
    LocationFourSquare location;
    @SerializedName("categories")
    ArrayList<Category> categories;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocationFourSquare getLocation() {
        return location;
    }

    public void setLocation(LocationFourSquare location) {
        this.location = location;
    }

    public ArrayList<Category> getCategories() {
        return categories;
    }

    public void setCategories(ArrayList<Category> categories) {
        this.categories = categories;
    }
}
