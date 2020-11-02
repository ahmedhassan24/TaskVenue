package com.example.task;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.viewpager.widget.ViewPager;

import android.Manifest;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;

import com.google.android.material.tabs.TabLayout;
import com.google.gson.JsonArray;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

public class Home extends AppCompatActivity {

    public static final int REQUEST_LOCATION = 1;
    final String Client_ID = "4EQRZPSGKBZGFSERGJY055FRW2OSPJRZYR4C3J0JN2CQQFIV";
    final String Client_Secret = "AJR4B5LLRONWAJWJJOACHAFLCWS2YJAZMGQNFFZQP0IB3THR";
    final String latitude = "30.0418061";
    final String longitude = "31.2021534";
    final String ll= latitude+","+longitude;
    final String foursquareUrl = "https://api.foursquare.com/v2/venues/search?ll="+ll+"&client_id="+Client_ID+"&client_secret="+Client_Secret+"&v=20180910\n";
    JsonFormatter jsonFormatter = new JsonFormatter();

    DrawerLayout drawerLayout;
    TabLayout tabLayout;
    ViewPager viewPager;
    final PageAdapter viewPageAdapter = new PageAdapter(getSupportFragmentManager());
    LocationManager locationManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        drawerLayout = findViewById(R.id.drawer_layout);
        tabLayout = findViewById(R.id.tab_layout);
        viewPager = findViewById(R.id.view_pager);

        //getLocation();
        JSONObject result = new JSONObject();
        String type = "GET";
        FourSquare fsq = new FourSquare();
        try {
            result = (JSONObject) fsq.execute(foursquareUrl,type).get();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            jsonFormatter.parse(result);
//            parseJSON(result);

        } catch (JSONException e) {
            e.printStackTrace();
        }
        TabHandler tabHandler = new TabHandler(viewPager,jsonFormatter,tabLayout);
        tabHandler.getTabs(viewPageAdapter);
//        getTabs();
    }
//    public void getTabs(){
//        new Handler().post(new Runnable() {
//            @Override
//            public void run() {
//                final PageAdapter viewPageAdapter = new PageAdapter(getSupportFragmentManager());
//                viewPageAdapter.addFragment(getListFragmentInstance(),"Venues");
//                viewPageAdapter.addFragment(getMapFragmentInstance(),"Map");
//                viewPager.setAdapter(viewPageAdapter);
//                tabLayout.setupWithViewPager(viewPager);
//            }
//        });
//    }

    // Return the ListFragment instance with appropriate data

//    private ListFragment getListFragmentInstance() {
//        ListFragment fragment=ListFragment.getInstance();
//
//        //Add some values to Bundle
//        Bundle bundle=new Bundle();
//        bundle.putSerializable("venues",jsonFormatter.getVenuesList());
////        bundle.putSerializable("venues",venuesList);
//
//        fragment.setArguments(bundle);
//        return fragment;
//    }

//    private MapFragment getMapFragmentInstance(){
//        MapFragment fragment = MapFragment.getInstance();
//        Bundle bundle=new Bundle();
//
//        bundle.putSerializable("venues",jsonFormatter.getVenuesList());
////        bundle.putSerializable("venues",venuesList);
//        fragment.setArguments(bundle);
//
//        return fragment;
//    }


//    private void getLocation() {
//        if (ActivityCompat.checkSelfPermission(
//                this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(
//                this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
//            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, REQUEST_LOCATION);
//        } else {
//            Location locationGPS = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
//            if (locationGPS != null) {
//                double latitude = locationGPS.getLatitude();
//                double longitude = locationGPS.getLongitude();
//            }
//        }
//    }
//    public void parseJSON(JSONObject json) throws JSONException {
//        JSONArray arr = json.getJSONObject("response").getJSONArray("venues");
//        JSONArray address;
//        for(int i=0;i<arr.length();i++) {
//            address = arr.getJSONObject(i).getJSONObject("location").getJSONArray("formattedAddress");
//            Venues venue = new Venues();
//            StringBuilder address_string = new StringBuilder();
//            for(int counter=0;counter<address.length();counter++)
//            {
//                if(counter == address.length()-1)
//                {
//                    address_string.append(address.getString(counter));
//                }
//                else
//                {
//                    address_string.append(address.getString(counter));
//                    address_string.append(" ");
//                }
//            }
//            venue.setAddress(address_string.toString());
//            venue.setCategory(arr.getJSONObject(i).getJSONArray("categories").getJSONObject(0).getString("name"));
//            venue.setName(arr.getJSONObject(i).getString("name"));
//            venue.setLatitude(arr.getJSONObject(i).getJSONObject("location").getString("lat"));
//            venue.setLongitude(arr.getJSONObject(i).getJSONObject("location").getString("lng"));
//
//            try{
//                venuesList.add(venue);
//            }
//            catch (Exception e)
//            {
//                e.printStackTrace();
//            }
//        }
//    }
    public void clickMenu(View view){
        Dashboard.openDrawer(drawerLayout);
    }
    public void clickHome(View view) {
        recreate();
    }
    public void clickMyProfile(View view) {
        ActivityHandler.redirect(this, MyProfile.class);
    }
    public void clickTermsAndConditions(View view) {
        ActivityHandler.redirect(this, TermsAndConditions.class);
    }
    public void clickLogOut(View view) {
        ActivityHandler.redirect(this, Login.class);
    }
}
