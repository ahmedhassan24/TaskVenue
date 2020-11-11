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
import androidx.fragment.app.FragmentTransaction;

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
    Places places = new Places();
    ArrayList<VenuesGson> venuesGsonArrayList = new ArrayList<>();
    ArrayList<Double> latitude = new ArrayList<>();
    ArrayList<Double> longitude = new ArrayList<>();
    Marker marker;
    SupportMapFragment supportMapFragment;

    public static MapFragment getInstance() {
        return new MapFragment();
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.mapfragment, container, false);
        supportMapFragment = new SupportMapFragment();
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
            places = (Places) getArguments().getSerializable("venues");
            venuesGsonArrayList = places.getResponse().getVenuesGson();
            for(int i=0;i<venuesGsonArrayList.size();i++) {
                LatLng latLng = new LatLng(venuesGsonArrayList.get(i).getLocation().getLat(),venuesGsonArrayList.get(i).getLocation().getLng());
                marker = googleMap.addMarker(new MarkerOptions().position(latLng).title(venuesGsonArrayList.get(i).getName()).visible(true));
            }
            LatLng home = new LatLng(30.0418061,31.2021534);
            googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(home,14));
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        supportMapFragment = new SupportMapFragment();
        supportMapFragment = (SupportMapFragment)
                getActivity().getSupportFragmentManager().findFragmentById(R.id.google_map);
        openMap();
    }
    @Override
    public void onPause() {
        super.onPause();
//        try {
//            if(supportMapFragment!= null) {
//                supportMapFragment = null;
//            }
//        }catch (Exception e){
//
//        }
        supportMapFragment = null;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
//        try {
//            FragmentTransaction ft = getActivity().getSupportFragmentManager().beginTransaction();
//            ft.remove(supportMapFragment);
//            ft.commit();
//        }catch (Exception e){
//
//        }
        supportMapFragment = null;

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        supportMapFragment = null;
    }

    public void openMap(){
        if(supportMapFragment == null){
            supportMapFragment = new SupportMapFragment();
            supportMapFragment = SupportMapFragment.newInstance();
            getActivity().getSupportFragmentManager().beginTransaction()
                    .replace(R.id.google_map, supportMapFragment, "MAP_FRAGMENT")
                    .commit();
        }
        supportMapFragment.getMapAsync(this);
    }
}
