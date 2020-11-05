package com.example.task;

import android.graphics.drawable.Icon;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class Category {
    @SerializedName("name")
    String categoryName;
    @SerializedName("icon")
    VenuesIcon icon;
}
