package com.example.hackeru.broadcastreceiverglobal;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.telephony.SmsManager;
import android.widget.Toast;

/**
 * Created by hackeru on 7/11/2016.
 */
public class SmsSentReceiver extends BroadcastReceiver{

    @Override
    public void onReceive(Context context, Intent intent) {
        int status = getResultCode();
        switch(status){
            case Activity.RESULT_OK:
                Toast.makeText(context, "SMS sent successfully", Toast.LENGTH_LONG).show();
                // change text to status textView...
                Intent sendBackIntent = new Intent("Maayan");
                context.sendBroadcast(sendBackIntent);  // send local broadcast...
                break;
            case SmsManager.RESULT_ERROR_NO_SERVICE:
                Toast.makeText(context, "RESULT_ERROR_NO_SERVICE", Toast.LENGTH_LONG).show();
                break;
            case SmsManager.RESULT_ERROR_NULL_PDU:
                // the number is wrong...
                Toast.makeText(context, "RESULT_ERROR_NULL_PDU", Toast.LENGTH_LONG).show();
                break;
            case SmsManager.RESULT_ERROR_GENERIC_FAILURE:
                // problem...
                Toast.makeText(context, "RESULT_ERROR_GENERIC_FAILURE", Toast.LENGTH_LONG).show();
                break;
            default:
                Toast.makeText(context, "DEFAULT problem: " + status, Toast.LENGTH_LONG).show();
                break;

        }
    }

}
