package com.example.hackeru.whatsapp;

import android.content.Intent;
import android.os.Bundle;

public class MainActivity extends BaseAuthenticatedActivity {

    @Override
    protected void onLoggedIn(Bundle savedInstanceState) {  // like onCreate but for logged in users!
        setContentView(R.layout.activity_main);
        Intent intent = new Intent(this, ChatActivity.class);
        startActivity(intent);
    }
}
