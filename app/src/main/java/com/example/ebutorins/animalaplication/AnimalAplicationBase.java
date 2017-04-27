package com.example.ebutorins.animalaplication;

import android.app.Application;
import android.content.Context;

/**
 * Created by ebutorins on 5/23/2016.
 */
public class AnimalAplicationBase extends Application {

    private static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        context = getApplicationContext();
    }

    public static Context getContext() {
        return context;
    }
}
