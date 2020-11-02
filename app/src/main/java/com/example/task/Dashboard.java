package com.example.task;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Dashboard extends AppCompatActivity {

    DrawerLayout drawerLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        drawerLayout = findViewById(R.id.drawer_layout);
    }
    public void clickMenu(View view) {
        openDrawer(drawerLayout);
    }
    public static void openDrawer(DrawerLayout drawerLayout){
        drawerLayout.openDrawer(GravityCompat.START);
    }

    public void clickHome(View view) {
        ActivityHandler.redirect(this, Home.class); }
    public void clickTermsAndConditions(View view) {
        ActivityHandler.redirect(this, TermsAndConditions.class);
    }
    public void clickMyProfile(View view) {
        ActivityHandler.redirect(this, Home.class);
    }
    public void clickLogOut(View view) {
        ActivityHandler.redirect(this, Login.class);
    }
}