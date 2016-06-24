package com.example.hackeru.passingdatabetweenactivities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        TextView textView = (TextView) findViewById(R.id.textView);

        String name = getIntent().getStringExtra(MainActivity.NAME);

        textView.setText("Hello " + name);



    }
}
