package com.example.task;

import android.app.Activity;
import android.content.Intent;

public class ActivityHandler {
    public static void redirect(Activity activity, Class aClass) {
        Intent intent = new Intent(activity,aClass);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        activity.startActivity(intent);
    }
}
