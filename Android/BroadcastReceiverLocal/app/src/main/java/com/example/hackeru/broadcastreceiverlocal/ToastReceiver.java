package com.example.hackeru.broadcastreceiverlocal;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

/**
 * Created by hackeru on 7/7/2016.
 */
public class ToastReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context, "hello from receiver", Toast.LENGTH_LONG).show();
    }
}
