package com.example.task;
import android.os.AsyncTask;
import android.util.Log;
//import cz.msebera.android.httpclient.HttpResponse;
////import cz.msebera.android.httpclient.client.HttpClient;
////import cz.msebera.android.httpclient.client.methods.HttpGet;
////import cz.msebera.android.httpclient.impl.client.DefaultHttpClient;
////import cz.msebera.android.httpclient.util.ByteArrayBuffer;
import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONArray;
import org.json.JSONObject;
import java.io.BufferedInputStream;
import java.io.InputStream;

import cz.msebera.android.httpclient.HttpResponse;
import cz.msebera.android.httpclient.client.HttpClient;
import cz.msebera.android.httpclient.client.methods.HttpGet;
import cz.msebera.android.httpclient.impl.client.DefaultHttpClient;
import cz.msebera.android.httpclient.util.ByteArrayBuffer;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface FourSquare {//extends AsyncTask<String,String,Object> {


    @GET(Constants.relativeURL3)
    Call<Places> getPlaces(
            @Query("client_id") String client_id,
            @Query("client_secret") String client_secret,
            @Query("ll") String ll ,
            @Query("v") String v
           );

//    @Override
//    protected JSONObject doInBackground(String... strings) {
//        String data;
//        try {
//            URL url = new URL(strings[0]);
//            HttpURLConnection httpCon = (HttpURLConnection) url.openConnection();
//            httpCon.setDoOutput(true);
//            httpCon.setRequestProperty("Content-Type", "application/json");
//            httpCon.setRequestProperty("Accept", "/");
//            httpCon.setRequestProperty("User-Agent", "Mozilla/5.0 ( compatible )");
//            httpCon.setRequestMethod(strings[1]);
//            int responseCode = httpCon.getResponseCode();
//
//            if(responseCode == httpCon.HTTP_OK) {
//                InputStream is = httpCon.getInputStream();
//                BufferedReader bufferreader = new BufferedReader(new InputStreamReader(is));
//                String line = "";
//                data = " ";
//                while (line != null) {
//                    line = bufferreader.readLine();
//                    data = data + line;
//                }
//                JSONObject json = new JSONObject(data);
//
//                return json;
//            }
//
//        } catch (Exception ex) {
//            ex.printStackTrace();
//            Log.e("exception input stream", String.valueOf(ex));
//        }
//        return null;
//    }

}
