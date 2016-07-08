package com.example.hackeru.broadcastreceiverlocal;

import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private ToastReceiver receiver;
    private IntentFilter filter;

    //https://developer.android.com/training/basics/activity-lifecycle/starting.html

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        receiver = new ToastReceiver();

        filter = new IntentFilter("99fm");

    }

    @Override
    protected void onResume() {
        super.onResume();
        registerReceiver(receiver, filter);
    }

    @Override
    protected void onPause() {
        super.onPause();
        unregisterReceiver(receiver);
    }

    public void launch(View view) {
        Intent intent = new Intent("99fm");
        sendBroadcast(intent);
    }
}
