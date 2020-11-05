package com.example.task;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.task.SQL.DatabaseHandler;

public class Login extends AppCompatActivity {
    Button buttonLogin;
    private static final String status = "signUp";
    EditText email_edit, password_edit;
    private SharedPreferences sharedPreferences;
    UserSession session;
    private DatabaseHandler databaseHandler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        email_edit = findViewById(R.id.input_email);
        password_edit = findViewById(R.id.input_password);
        buttonLogin = findViewById(R.id.btn_login);
        session = new UserSession(getApplicationContext());
        sharedPreferences = getSharedPreferences(status, Context.MODE_PRIVATE);
        databaseHandler = new DatabaseHandler(this);
    }

//    public void login(View view) {
//        String email = email_edit.getText().toString();
//        String password = password_edit.getText().toString();
//        if (email.trim().length() > 0 && password.trim().length() > 0) {
//            String s_email = null;
//            String s_Password = null;
//
//            if (sharedPreferences.contains("Email")) {
//                s_email = sharedPreferences.getString("Email", "");
//
//            }
//
//            if (sharedPreferences.contains("Password")) {
//                s_Password = sharedPreferences.getString("Password", "");
//
//            }
//            if (email.equals(s_email) && password.equals(s_Password)) {
//
//                session.createUserLoginSession(s_email,
//                        s_Password);
//                ActivityHandler.redirect(this, Home.class);
//            } else {
//                Toast.makeText(getApplicationContext(),
//                        "Email or Password is incorrect",
//                        Toast.LENGTH_LONG).show();
//            }
//        }
//    }

    public void login(View view){
        verifyUserLogin();
    }

    public void verifyUserLogin() {
        if (databaseHandler.checkUserLogin(email_edit.getText().toString()
                , password_edit.getText().toString())) {

            ActivityHandler.redirect(this, Home.class);
        }
        else
        {
            Toast.makeText(getApplicationContext(),
                        "Email or Password is incorrect",
                        Toast.LENGTH_LONG).show();
        }
    }

    public void signup(View view) {
        ActivityHandler.redirect(this, Signup.class);
    }
}