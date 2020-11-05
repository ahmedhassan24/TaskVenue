package com.example.task;

import android.location.Location;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class VenuesGson {
    @SerializedName("name")
    @Expose
    String Name;
    @SerializedName("location")
    @Expose
    Location location;
    @SerializedName("categories")
    @Expose
    ArrayList<Category> categories;

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public ArrayList<Category> getCategories() {
        return categories;
    }

    public void setCategories(ArrayList<Category> categories) {
        this.categories = categories;
    }
}
