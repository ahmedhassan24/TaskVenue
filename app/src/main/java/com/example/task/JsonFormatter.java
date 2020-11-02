package com.example.task;

import com.google.gson.JsonObject;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class JsonFormatter {
    ArrayList<Venues> venuesList = new ArrayList<>();


    public void parse(JSONObject json) throws JSONException {
        JSONArray arr = json.getJSONObject("response").getJSONArray("venues");
        JSONArray address;
        for(int i=0;i<arr.length();i++) {
            address = arr.getJSONObject(i).getJSONObject("location").getJSONArray("formattedAddress");
            Venues venue = new Venues();
            StringBuilder address_string = new StringBuilder();
            for(int counter=0;counter<address.length();counter++)
            {
                if(counter == address.length()-1)
                {
                    address_string.append(address.getString(counter));
                }
                else
                {
                    address_string.append(address.getString(counter));
                    address_string.append(" ");
                }
            }
            venue.setAddress(address_string.toString());
            venue.setCategory(arr.getJSONObject(i).getJSONArray("categories").getJSONObject(0).getString("name"));
            venue.setName(arr.getJSONObject(i).getString("name"));
            venue.setLatitude(arr.getJSONObject(i).getJSONObject("location").getString("lat"));
            venue.setLongitude(arr.getJSONObject(i).getJSONObject("location").getString("lng"));
            venue.setIcon(arr.getJSONObject(i).getJSONArray("categories").getJSONObject(0).getJSONObject("icon").getString("prefix")+"bg_32.png");

            try{
                venuesList.add(venue);
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        }

    }

    public ArrayList<Venues> getVenuesList() {
        return venuesList;
    }

    public void setVenuesList(ArrayList<Venues> venuesList) {
        this.venuesList = venuesList;
    }
}
