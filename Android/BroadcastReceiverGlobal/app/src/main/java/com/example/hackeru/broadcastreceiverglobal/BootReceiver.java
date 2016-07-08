package com.example.hackeru.broadcastreceiverglobal;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

/**
 * Created by hackeru on 7/7/2016.
 */
public class BootReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        /*
        Intent bootIntent = new Intent(context, MainActivity.class);
        bootIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(bootIntent);
        */
        //Toast.makeText(context, "called!!!", Toast.LENGTH_LONG).show();
        /*
        go to the internet and check for messages...
        if(messages.size() > 0){
            create notification...
         */
    }
}
