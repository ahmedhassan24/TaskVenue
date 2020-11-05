package com.example.task;

import android.os.AsyncTask;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class JsonFormatter    {
    Places places = new Places();
    Response response1 = new Response();
    OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
    public static ArrayList<Venues> venuesList = new ArrayList<>();



//    public void parse(JSONObject json) throws JSONException {
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
//                    address_string.append(address.getString(counter) );
//                    address_string.append(" ");
//                }
//            }
//            venue.setAddress(address_string.toString());
//            venue.setCategory(arr.getJSONObject(i).getJSONArray("categories").getJSONObject(0).getString("name"));
//            venue.setName(arr.getJSONObject(i).getString("name"));
//            venue.setLatitude(arr.getJSONObject(i).getJSONObject("location").getString("lat"));
//            venue.setLongitude(arr.getJSONObject(i).getJSONObject("location").getString("lng"));
//            venue.setIcon(arr.getJSONObject(i).getJSONArray("categories").getJSONObject(0).getJSONObject("icon").getString("prefix")+"bg_32.png");
//
//            try{
//                venuesList.add(venue);
//            }
//            catch (Exception e)
//            {
//                e.printStackTrace();
//            }
//        }
//
//    }

    public void parseGson(){
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Constants.baseURL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .client(httpClient.build())
                .build();
        FourSquare fourSquare = retrofit.create(FourSquare.class);

        Call<Places> call = fourSquare.getPlaces(Constants.Client_ID,Constants.Client_Secret,Constants.ll,Constants.v);
//        Log.d("RESPONEEEE", String.valueOf(fourSquare.getPlaces(Constants.Client_ID,Constants.Client_Secret,Constants.ll,Constants.v)));
        call.enqueue(new retrofit2.Callback<Places>() {
            @Override
            public void onResponse(Call<Places> call, retrofit2.Response<Places> response) {
                if(response.isSuccessful())
                {
                    Log.d("Ana tamam", "Tamaaaaaam");
                }
                assert response.body() != null;
                response1 = response.body().getResponse();
            }

            @Override
            public void onFailure(Call<Places> call, Throwable t) {
                Log.d("El error", String.valueOf(t));

            }
        });


    }

    public ArrayList<Venues> getVenuesList() {
        return venuesList;
    }

    public void setVenuesList(ArrayList<Venues> venuesList) {
        this.venuesList = venuesList;
    }


}
