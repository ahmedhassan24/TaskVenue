package com.example.task;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.task.SQL.DatabaseHandler;
import com.google.android.material.snackbar.Snackbar;

public class Signup extends AppCompatActivity {

    SharedPreferences sharedPreferences;
    EditText first_Name, last_Name, email_edit, age_edit, password_edit;
    Button regButton;
    SharedPreferences.Editor editor;
    User user = new User();
    DatabaseHandler databaseHandler;

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
        databaseHandler = new DatabaseHandler(this);
    }

    public void signup(View view) {
        postDataToDatabase();
    }

    public void postDataToDatabase() {
        String firstName = first_Name.getText().toString();
        String lastName = last_Name.getText().toString();
        String age = age_edit.getText().toString();
        String email = email_edit.getText().toString();
        String password = password_edit.getText().toString();
        if (databaseHandler.checkUser(email)) {
            Toast.makeText(getApplicationContext(),
                    "Email already exists",
                    Toast.LENGTH_LONG).show();
        } else {
            user.setFirstName(firstName);
            user.setLastName(lastName);
            user.setEmail(email);
            user.setPassword(password);
            user.setAge(age);
            databaseHandler.addUser(user);
            ActivityHandler.redirect(this, Login.class);
        }
    }
}