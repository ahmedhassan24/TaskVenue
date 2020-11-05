package com.example.task;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ListFragment extends Fragment {
    ListView venuesList;


    public static ListFragment getInstance() {
        return new ListFragment();
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.listfragment, container, false);
        venuesList = view.findViewById(R.id.listView);
        ArrayList<Venues> venues = new ArrayList<Venues>();
        Venues venues1 = new Venues();
        venues1.setIcon("https://ss3.4sqi.net/img/categories_v2/parks_outdoors/plaza_bg_32.png");
        venues1.setLongitude("3333");
        venues1.setLatitude("44444");
        venues1.setName("AHMED");
        venues1.setCategory("svsaaa");
        venues1.setAddress("aaaaaaa");
        venues.add(venues1);


//        Bundle bundle = getArguments();
//        if (bundle != null) {
//            venues = (ArrayList<Venues>)getArguments().getSerializable("venues");

            CustomAdapter customAdapter = new CustomAdapter(getContext(),venues);
            venuesList.setAdapter(customAdapter);
//        }
        return view;
    }
}

