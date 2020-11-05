package com.example.task;

import android.content.Context;
import android.content.SharedPreferences;

import java.util.logging.SocketHandler;

public class UserSession {
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    int PRIVATE_MODE = 0;
    public static final String status = "signUp";
    public static final String IS_USER_LOGIN = "IsUserLoggedIn";
    public static final String EMAIL = "Email";
    public static final String PASSWORD = "password";




    // password
    public static final String KEY_PASSWORD = "txtPassword";
    Context _context;
    public UserSession(Context context){
        this._context = context;
        sharedPreferences = _context.getSharedPreferences(status, PRIVATE_MODE);
        editor = sharedPreferences.edit();
    }

    public void createUserLoginSession(String s_email, String s_password){
        editor.putBoolean(IS_USER_LOGIN, true);
        editor.putString(EMAIL, s_email);
        editor.putString(PASSWORD,  s_password);
        editor.commit();
    }

}
