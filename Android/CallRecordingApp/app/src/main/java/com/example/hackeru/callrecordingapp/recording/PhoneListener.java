package com.example.hackeru.callrecordingapp.recording;

import android.content.Context;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import android.widget.Toast;

/**
 * Created by hackeru on 7/14/2016.
 */
public class PhoneListener extends PhoneStateListener {

    private Context context;

    public PhoneListener(Context context){
        this.context = context;
    }

    @Override
    public void onCallStateChanged(int state, String incomingNumber) {
        switch(state){
            case TelephonyManager.CALL_STATE_RINGING:
                // someone is calling me...
                break;
            case TelephonyManager.CALL_STATE_OFFHOOK:
                // call started!!!
                Toast.makeText(context, "call started", Toast.LENGTH_SHORT).show();
                break;
            case TelephonyManager.CALL_STATE_IDLE:
                // call ended...
                Toast.makeText(context, "call ended", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
