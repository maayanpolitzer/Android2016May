package com.example.hackeru.firstapp;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

/**
 * Created by hackeru on 6/20/2016.
 */
public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }


    public void displayAlert(View view) {
        Toast.makeText(this, "WORKING!!!!", Toast.LENGTH_LONG).show();
    }
}
