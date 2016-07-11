package com.example.hackeru.broadcastreceiverglobal;

import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class SmsActivity extends AppCompatActivity implements View.OnClickListener {

    private String momPhone = "0522222222";
    private String dadPhone = "0533333333";

    private RadioGroup radioGroup;
    private EditText messageEditText;
    private Button sendSmsBtn;
    private TextView statusTextView;    // DONT USE STATIC!!!
    private BroadcastReceiver sentLocalReceiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sms);

        radioGroup = (RadioGroup) findViewById(R.id.group);
        messageEditText = (EditText) findViewById(R.id.message_edit_text);
        sendSmsBtn = (Button) findViewById(R.id.send_button);
        statusTextView = (TextView) findViewById(R.id.sms_status_text_view);

        sendSmsBtn.setOnClickListener(this);

        sentLocalReceiver = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                statusTextView.setText("SMS sent");
            }
        };
    }

    @Override
    protected void onResume() {
        super.onResume();
        IntentFilter filter = new IntentFilter("Maayan");
        registerReceiver(sentLocalReceiver, filter);
    }

    @Override
    protected void onPause() {
        super.onPause();
        unregisterReceiver(sentLocalReceiver);
    }

    @Override
    public void onClick(View v) {
        int checkedRadio = radioGroup.getCheckedRadioButtonId();
        String to = "";
        if (checkedRadio != -1){    // all radio buttons not checked.
            String message = messageEditText.getText().toString().trim();
            if (checkedRadio == R.id.radioButtonMom){
                to = momPhone;
            }else{
                to = dadPhone;
            }
           // Toast.makeText(this, to + "," + message, Toast.LENGTH_LONG).show();
            sendSMS(to, message);
        }
    }

    private void sendSMS(String to, String message){
        SmsManager manager = SmsManager.getDefault();   // get the manager of sms in my android phone (there is only one).
        PendingIntent smsSentPI = PendingIntent.getBroadcast(this, 123, new Intent("SENT_SMS"), 0);     // "SENT_SMS" is the action to trigger the receiver.
        PendingIntent deliveredPI = PendingIntent.getBroadcast(this, 567, new Intent("DELIVERED_SMS"), 0);
        manager.sendTextMessage(to, null, message, smsSentPI, deliveredPI);

    }
}
