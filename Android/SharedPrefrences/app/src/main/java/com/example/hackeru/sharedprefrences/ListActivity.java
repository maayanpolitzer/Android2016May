package com.example.hackeru.sharedprefrences;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        TextView textView = (TextView) findViewById(R.id.textView);
        //String user = getIntent().getStringExtra("USERNAME");
        String user = LoginActivity.settings.getString("USERNAME", null);
        textView.setText("Hi " + user);

    }
}
