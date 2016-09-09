package com.example.hackeru.whatsapp;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by hackeru on 8/29/2016.
 */
public abstract class BaseActivity extends AppCompatActivity {

    private static final String PREFS_NAME = "prefs";
    public static final String USER_ID = "userId";

    protected SharedPreferences settings;
    protected SharedPreferences.Editor editor;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        settings = getSharedPreferences(PREFS_NAME, MODE_PRIVATE);
        editor = settings.edit();
    }
}
