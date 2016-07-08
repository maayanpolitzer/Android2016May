package com.example.hackeru.broadcastreceiverglobal;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by hackeru on 7/7/2016.
 */
public class OutgoingCallReceiver extends BroadcastReceiver {

    private String momPhone = "0522222222";
    private String dadPhone = "0533333333";

    @Override
    public void onReceive(Context context, Intent intent) {
        String phoneNumber = intent.getStringExtra(Intent.EXTRA_PHONE_NUMBER);
        if (!phoneNumber.equals(momPhone) && !phoneNumber.equals(dadPhone)){
            setResultData(null);    // block the call!!!
            Toast.makeText(context, "Don't call there!!! :( ", Toast.LENGTH_LONG).show();
        }
    }
}
