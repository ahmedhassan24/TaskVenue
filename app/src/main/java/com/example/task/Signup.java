package com.example.task;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Signup extends AppCompatActivity {

    SharedPreferences sharedPreferences;
    EditText first_Name, last_Name, email_edit, age_edit, password_edit;
    Button regButton;
    SharedPreferences.Editor editor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        first_Name = findViewById(R.id.firstName);
        last_Name = findViewById(R.id.lastName);
        password_edit = findViewById(R.id.input_password);
        email_edit = findViewById(R.id.input_email);
        age_edit = findViewById(R.id.age);
        regButton = (Button) findViewById(R.id.btn_signup);

        sharedPreferences = getApplicationContext().getSharedPreferences("signUp", 0);
        editor = sharedPreferences.edit();
    }

    public void signup(View view) {
        String firstName = first_Name.getText().toString();
        String lastName = last_Name.getText().toString();
        String age = age_edit.getText().toString();
        String email = email_edit.getText().toString();
        String password = password_edit.getText().toString();


        editor.putString("First Name", firstName);
        editor.putString("Last Name", lastName);
        editor.putString("Age", age);
        editor.putString("Email", email);
        editor.putString("Password",password);
        editor.commit();
        Dashboard.redirect(this, Login.class);
    }
}