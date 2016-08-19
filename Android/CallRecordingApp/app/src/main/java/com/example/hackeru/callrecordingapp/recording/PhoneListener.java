package com.example.hackeru.callrecordingapp.recording;

import android.content.Context;
import android.content.Intent;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import android.widget.Toast;

/**
 * Created by hackeru on 7/14/2016.
 */
public class PhoneListener extends PhoneStateListener {

    static final String PHONE_NUMBER = "phone number";
    static final String STATE = "state";
    private Context context;
    private static int lastState = -1;  // 0 is TelephonyManager.CALL_STATE_IDLE.
    private static boolean recording = false;


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
                if (!recording){
                    setRecord(true, incomingNumber, lastState == TelephonyManager.CALL_STATE_RINGING ? CallState.INCOMING : CallState.OUTGOING);
                }
                Toast.makeText(context, "call started", Toast.LENGTH_SHORT).show();
                break;
            case TelephonyManager.CALL_STATE_IDLE:
                // call ended...
                if (recording){
                    setRecord(false, null, null);
                }
                Toast.makeText(context, "call ended", Toast.LENGTH_SHORT).show();
                break;
        }
        lastState = state;
    }

    /**
     * Method that will start or stop the recording.
     * @param start boolean - true will start the recording, false will stop it.
     * @param phoneNumber String -
     * @param state CallState - INCOMING or OUTGOING or null if call ended.
     */
    private void setRecord(boolean start, String phoneNumber, CallState state){
        Intent intent = new Intent(context, RecordingService.class);
        recording = start;
        if (start){
            intent.putExtra(PHONE_NUMBER, phoneNumber);
            intent.putExtra(STATE, state == CallState.INCOMING ? 1 : 0);
            context.startService(intent);
        }else{
            context.stopService(intent);
        }
    }

    enum CallState {
        INCOMING, OUTGOING
    }


}
