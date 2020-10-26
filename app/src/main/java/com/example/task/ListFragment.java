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
        ListFragment list_Fragment = new ListFragment();
        return list_Fragment;
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
        ArrayList<String> venuesNameList = new ArrayList<>();
        ArrayList<String> venuesAddressList = new ArrayList<>();
        ArrayList<String> venuesCategoryList = new ArrayList<>();
        ArrayList<String> venuesIconList = new ArrayList<>();
        ArrayList<Venues> venues;
        ArrayList<String> result = new ArrayList<>();


        Bundle bundle = getArguments();
        if (bundle != null) {
            venues = (ArrayList<Venues>)getArguments().getSerializable("venues");
            for (int i = 0; i < venues.size(); i++) {
                result.add(venues.get(i).getName() + "\n" + "\n" + venues.get(i).getAddress() + "\n" + "\n" +
                        venues.get(i).getCategory() + "\n");
            }

            ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, result);
            venuesList.setAdapter(arrayAdapter);
        }
        return view;
    }
}

