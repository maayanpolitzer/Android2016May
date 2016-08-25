package com.example.hackeru.callrecordingapp.recording;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;

/**
 * Created by hackeru on 7/14/2016.
 */
public class CallReceiver extends BroadcastReceiver {

    private PhoneListener listener;
    private TelephonyManager manager;

    // action defined in manifest.

    @Override
    public void onReceive(Context context, Intent intent) {
        manager = (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);   // get the calls manager.
        listener = new PhoneListener(context);
        manager.listen(listener, PhoneStateListener.LISTEN_CALL_STATE); //  start listen to call change
    }

}
