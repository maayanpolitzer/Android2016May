package com.example.hackeru.broadcastreceiverglobal;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class DeliveredReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        int status = getResultCode();
        switch (status){
            case Activity.RESULT_OK:
                Toast.makeText(context, "Delivered", Toast.LENGTH_LONG).show();
                break;
            case Activity.RESULT_CANCELED:

                break;
        }
    }
}
