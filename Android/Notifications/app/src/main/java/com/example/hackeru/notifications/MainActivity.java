package com.example.hackeru.notifications;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.NotificationCompat;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private NotificationManager manager;
    private int counter = 0;
    private BroadcastReceiver receiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        manager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        receiver = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                manager.cancel(879);
                finish();
            }
        };
    }

    @Override
    protected void onResume() {
        super.onResume();
        IntentFilter filter = new IntentFilter("99fm");
        registerReceiver(receiver, filter);
    }

    @Override
    protected void onPause() {
        super.onPause();
        unregisterReceiver(receiver);
    }

    public void show(View view) {
        Button btn = (Button) view;
        Toast.makeText(this, btn.getText(), Toast.LENGTH_SHORT).show();
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this);
        builder.setContentTitle("New message");
        builder.setContentText("how are you? " + counter++);
        builder.setSmallIcon(android.R.drawable.ic_btn_speak_now);
        PendingIntent pi = PendingIntent.getActivity(this, 45, new Intent(this, MainActivity.class), 0);
        PendingIntent closeAppPI = PendingIntent.getBroadcast(this, 332, new Intent("99fm"), 0);
        builder.addAction(R.mipmap.ic_launcher, "exit app", closeAppPI);
        builder.setContentIntent(pi);
        manager.notify(879, builder.build());
    }

    public void hide(View view) {
    }
}
