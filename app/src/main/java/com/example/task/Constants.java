package com.example.task;

public class Constants {
    public static final String Client_ID = "4EQRZPSGKBZGFSERGJY055FRW2OSPJRZYR4C3J0JN2CQQFIV";
    public static final String Client_Secret = "AJR4B5LLRONWAJWJJOACHAFLCWS2YJAZMGQNFFZQP0IB3THR";
    public static final String latitude = "30.0418061";
    public static final String longitude = "31.2021534";
    public static final String ll= latitude+","+longitude;
    public static final String v = "20180910";
    public static final String foursquareUrl = "https://api.foursquare.com/v2/venues/search?ll="+ll+"&client_id="+Client_ID+"&client_secret="+Client_Secret+"&v="+v;
    public static final String getRequest = "GET";
    public static final int REQUEST_LOCATION = 1;
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "UserManager.db";
    public static final String TABLE_USER = "user";
    public static final String COLUMN_USER_ID = "user_id";
    public static final String COLUMN_USER_NAME = "user_name";
    public static final String COLUMN_USER_EMAIL = "user_email";
    public static final String COLUMN_USER_PASSWORD = "user_password";
    public static final String COLUMN_USER_AGE = "user_age";
    public static final String baseURL = "https://api.foursquare.com";
    public static final String relativeURL = "v2/venues/search?ll="+ll+"&client_id="+Client_ID+"&client_secret="+Client_Secret+"&v="+v;
    public static final String relativeURL2 = "v2/venues/search?ll={ll}&client_id={Client_ID}&client_secret={client_secret}&v={v}";
    public static final String relativeURL3 = "/v2/venues/search";
    public String getClient_ID() {
        return Client_ID;
    }

    public String getClient_Secret() {
        return Client_Secret;
    }

    public String getLatitude() {
        return latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public String getLl() {
        return ll;
    }

    public String getFoursquareUrl() {
        return foursquareUrl;
    }
}
