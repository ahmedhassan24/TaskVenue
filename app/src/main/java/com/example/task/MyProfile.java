package com.example.task;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.os.Bundle;
import android.view.View;

public class MyProfile extends AppCompatActivity {

    DrawerLayout drawerLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_profile);

        drawerLayout = findViewById(R.id.drawer_layout);
    }
    public void clickMenu(View view){
        Dashboard.openDrawer(drawerLayout);
    }
    public void clickHome(View view) {
        ActivityHandler.redirect(this, Home.class);
    }
    public void clickMyProfile(View view) {
        recreate();
    }
    public void clickTermsAndConditions(View view) {
        ActivityHandler.redirect(this, TermsAndConditions.class);
    }
    public void clickLogOut(View view) {
        ActivityHandler.redirect(this, Login.class);
    }
}