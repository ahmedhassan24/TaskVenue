package com.example.task;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;

public class MapFragment extends Fragment implements OnMapReadyCallback {
    GoogleMap googleMap;
    ArrayList<Venues> venues = new ArrayList<>();
    ArrayList<Double> latitude = new ArrayList<>();
    ArrayList<Double> longitude = new ArrayList<>();
    Marker marker;
    SupportMapFragment supportMapFragment;

    public static MapFragment getInstance() {
        MapFragment map_Fragment = new MapFragment();
        return map_Fragment;
    }
    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.mapfragment, container, false);
        supportMapFragment = (SupportMapFragment)
                getActivity().getSupportFragmentManager().findFragmentById(R.id.google_map);
        openMap();
        return view;
    }

    @Override
    public void onMapReady(GoogleMap google_Map) {
        googleMap = google_Map;
        MarkerOptions markerOptions = new MarkerOptions();
        Bundle bundle = getArguments();
        if (bundle != null) {
            venues = (ArrayList<Venues>) getArguments().getSerializable("venues");
            for(int i=0;i<venues.size();i++) {
                LatLng latLng = new LatLng(venues.get(i).getLatitude(),venues.get(i).getLongitude());
                marker = googleMap.addMarker(new MarkerOptions().position(latLng).title(venues.get(i).getName()).visible(true));
            }
            LatLng home = new LatLng(30.0418061,31.2021534);
            googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(home,14));
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        openMap();
    }
    @Override
    public void onPause() {
        super.onPause();
        if(supportMapFragment!= null) {
            supportMapFragment.onDestroy();
            googleMap.clear();
        }
    }
    public void openMap(){
        if(supportMapFragment == null){
            // Create new Map instance if it doesn't exist
            supportMapFragment = SupportMapFragment.newInstance();
            getActivity().getSupportFragmentManager().beginTransaction()
                    .replace(R.id.google_map, supportMapFragment, "MAP_FRAGMENT")
                    .commit();
        }
        supportMapFragment.getMapAsync(this);
    }
}
