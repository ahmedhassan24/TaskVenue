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

    JsonFormatter jsonFormatter = new JsonFormatter();
    Response response = new Response();
    DrawerLayout drawerLayout;
    TabLayout tabLayout;
    ViewPager viewPager;
    final PageAdapter viewPageAdapter = new PageAdapter(getSupportFragmentManager());
    LocationManager locationManager;
    Places places = new Places();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        drawerLayout = findViewById(R.id.drawer_layout);
        tabLayout = findViewById(R.id.tab_layout);
        viewPager = findViewById(R.id.view_pager);
//        //getLocation();
//        JSONObject result = new JSONObject();
////        String result = "";
//        FourSquare fsq = new FourSquare();
//        try {
//            result = (JSONObject) fsq.execute(Constants.foursquareUrl,Constants.getRequest).get();
//        } catch (ExecutionException e) {
//            e.printStackTrace();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        try {
//            jsonFormatter.parse(result);
////            jsonFormatter.parseGson(result);
//        } catch (JSONException e) {
//            e.printStackTrace();
//        }
//        jsonFormatter.parseGson();
        try {
            places = jsonFormatter.execute().get();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        TabHandler tabHandler = new TabHandler(viewPager,places,tabLayout);
        tabHandler.getTabs(viewPageAdapter);
    }



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


    @Override
    protected void onDestroy() {
        super.onDestroy();
        jsonFormatter.venuesList = null;
    }

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
