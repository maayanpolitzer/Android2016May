package com.example.hackeru.memorygameadvanced;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    static final String TAG = "tag";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void startGame(View view) {
        Intent intent = new Intent(this, GameActivity.class);
        int tag = Integer.parseInt(view.getTag().toString());  // convert object to int with help by toString.
        //int tag = (int) view.getTag(); // convert object to int by casting...(NOT WORKING)
        intent.putExtra(TAG, tag);     // can send primitive data!
        startActivity(intent);
    }
}
