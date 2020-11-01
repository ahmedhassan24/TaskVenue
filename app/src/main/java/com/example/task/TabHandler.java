package com.example.task;

import android.os.Bundle;
import android.os.Handler;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;

import java.util.Map;

public class TabHandler {

    private ViewPager viewPager;
    JsonFormatter jsonFormatter;
    TabLayout tabLayout;


    public TabHandler(ViewPager viewPager, JsonFormatter jsonFormatter,TabLayout tabLayout){
        this.viewPager = viewPager;
        this.jsonFormatter = jsonFormatter;
        this.tabLayout = tabLayout;
    }
    public void getTabs(PageAdapter viewPageAdapter){
        new Handler().post(new Runnable() {
            @Override
            public void run() {
//                final PageAdapter viewPageAdapter = new PageAdapter(getSupportFragmentManager());
                viewPageAdapter.addFragment(getListFragmentInstance(),"Venues");
                viewPageAdapter.addFragment(getMapFragmentInstance(),"Map");
                viewPager.setAdapter(viewPageAdapter);
                tabLayout.setupWithViewPager(viewPager);
            }
        });
    }

    private Fragment getMapFragmentInstance() {
        MapFragment fragment=MapFragment.getInstance();

        //Add some values to Bundle
        Bundle bundle=new Bundle();
        bundle.putSerializable("venues",jsonFormatter.getVenuesList());
//        bundle.putSerializable("venues",venuesList);

        fragment.setArguments(bundle);
        return fragment;
    }

    private Fragment getListFragmentInstance() {
        ListFragment fragment=ListFragment.getInstance();

        //Add some values to Bundle
        Bundle bundle=new Bundle();
        bundle.putSerializable("venues",jsonFormatter.getVenuesList());
//        bundle.putSerializable("venues",venuesList);

        fragment.setArguments(bundle);
        return fragment;
    }
}
