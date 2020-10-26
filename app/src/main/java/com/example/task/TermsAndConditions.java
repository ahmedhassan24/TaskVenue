package com.example.task;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.os.Bundle;
import android.view.View;

public class TermsAndConditions extends AppCompatActivity {

    DrawerLayout drawerLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_terms_and_conditions);
        drawerLayout= findViewById(R.id.drawer_layout);
    }
    public void clickMenu(View view){
        Dashboard.openDrawer(drawerLayout);
    }
    public void clickHome(View view) {
        Dashboard.redirect(this, Home.class);
    }
    public void clickMyProfile(View view) {
        Dashboard.redirect(this, MyProfile.class);
    }
    public void clickTermsAndConditions(View view) {
        recreate();
    }
    public void clickLogOut(View view) {
        Dashboard.redirect(this, Login.class);
    }
}