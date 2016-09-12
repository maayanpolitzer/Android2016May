package com.example.hackeru.whatsapp;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.NotificationCompat;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

/**
 * Created by hackeru on 8/29/2016.
 */
public abstract class BaseAuthenticatedActivity extends BaseActivity {

    protected static final String CHATTER = "chatter";
    protected static final String CHATTER_ID = "chatter_id";
    private GetMessageThread thread;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if(!userExists()){
            finish();
            Intent intent = new Intent(this, LoginActivity.class);
            startActivity(intent);
            return; // stop the onCreate method!!!
        }
        onLoggedIn(savedInstanceState);


    }

    protected void sendNotification(int from, String message){
        NotificationManager manager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        Notification notification = new NotificationCompat.Builder(this)
                .setSmallIcon(android.R.drawable.ic_dialog_email)
                .setContentTitle("Message from: " + from)
                .setContentText("Message: " + message)
                .build();
        manager.notify(12, notification);
    }


    @Override
    protected void onResume() {
        super.onResume();
        thread = new GetMessageThread(this, settings.getInt(USER_ID,-1));
        thread.start();
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (thread != null){
            thread.shutDown();
            thread = null;
        }
    }
/*
    public void messageArrived(int from, String message){
        if (this instanceof MainActivity){  // you are in MainActivity.
            Log.d("TAG", "mainActivity");
        }else{
            Log.d("TAG", "not... ChatActivity");
        }
    }
    */

    public abstract void messageArrived(int from, String message);

    private boolean userExists(){
        return settings.getInt(BaseActivity.USER_ID, -1) != -1; // check if user exists... return -1 if NOT!!!!
    }

    protected abstract void onLoggedIn(Bundle savedInstanceState);

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()){
            case R.id.action_logout:
                logout();
                break;
        }
        return true;
    }

    private void logout() {
        editor.clear();
        editor.commit();
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
        finish();
    }
}
