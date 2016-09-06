package com.example.hackeru.whatsapp;

import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends BaseAuthenticatedActivity {


    @Override
    protected void onLoggedIn(Bundle savedInstanceState) {
        // like onCreate but for logged in users!
        setContentView(R.layout.activity_main);
        Toast.makeText(this, "loggedIn", Toast.LENGTH_SHORT).show();
    }
}
