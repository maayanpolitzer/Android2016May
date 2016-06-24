package com.example.hackeru.linkingactivities;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void changeActivity(View view) {
        // TODO: go to second activity...
        // explicit intent...
        Intent intent = new Intent(this, SecondActivity.class);
        startActivity(intent);

/*
        // implicit intent - move to other app activity...
        Uri phoneNumber = Uri.parse("tel:0542222456");
        Intent intent = new Intent(Intent.ACTION_DIAL, phoneNumber);
        startActivity(intent);
        */
        /*
        Uri link = Uri.parse("http://www.youtube.com");
        Intent intent = new Intent(Intent.ACTION_VIEW, link);
        startActivity(intent);
        */
        /*
        Uri contacts = Uri.parse("content://contacts");
        startActivity(new Intent(Intent.ACTION_PICK, contacts));
        */
    }
}
