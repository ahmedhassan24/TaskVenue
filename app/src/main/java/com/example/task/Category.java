package com.example.task;

import android.graphics.drawable.Icon;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;

public class Category implements Serializable {
    @SerializedName("name")
    String categoryName;
    @SerializedName("icon")
    VenuesIcon icon;

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public VenuesIcon getIcon() {
        return icon;
    }

    public void setIcon(VenuesIcon icon) {
        this.icon = icon;
    }
}
