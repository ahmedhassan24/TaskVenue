package com.example.task;

import android.content.Context;
import android.database.DataSetObserver;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class CustomAdapter implements ListAdapter {
    ArrayList<Venues> arrayList = new ArrayList<Venues>();
    Context context;
    public CustomAdapter(Context context, ArrayList<Venues> arrayList) {
        this.arrayList=arrayList;
        this.context=context;
    }

    @Override
    public void registerDataSetObserver(DataSetObserver observer) {

    }

    @Override
    public void unregisterDataSetObserver(DataSetObserver observer) {

    }

    @Override
    public int getCount() {
        return arrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Venues venues=arrayList.get(position);
        if(convertView==null){
            LayoutInflater layoutInflater = LayoutInflater.from(context);
            convertView=layoutInflater.inflate(R.layout.venueslistview, null);
            TextView name=convertView.findViewById(R.id.name);
            TextView address=convertView.findViewById(R.id.address);
            TextView category=convertView.findViewById(R.id.category);
            ImageView icon=convertView.findViewById(R.id.icon);
            name.setText(venues.getName());
            address.setText(venues.getAddress());
            category.setText(venues.getCategory());
            Picasso.with(context)
                    .load(venues.getIcon())
                    .resize(200,200)
                    .into(icon);
        }
        return convertView;
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }

    @Override
    public int getViewTypeCount() {
        return arrayList.size();
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean areAllItemsEnabled() {
        return true;
    }

    @Override
    public boolean isEnabled(int position) {
        return false;
    }
}
