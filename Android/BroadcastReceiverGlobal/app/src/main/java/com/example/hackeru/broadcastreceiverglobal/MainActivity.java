package com.example.hackeru.broadcastreceiverglobal;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private String momPhone = "0522222222";
    private String dadPhone = "0533333333";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void onClick(View view) {
        int id = view.getId();
        switch (id){
            case R.id.call_mom_button:
                makeCall(momPhone);
                break;
            case R.id.call_dad_button:
                makeCall(dadPhone);
                break;
            case R.id.internet_button:
                launchBrowser();
                break;
            case R.id.sms_button:
                launchSmsActivity();
                break;
        }
    }

    private void launchBrowser(){
        Intent intent = new Intent(this, BrowserActivity.class);
        startActivity(intent);
    }

    private void launchSmsActivity(){
        Intent intent = new Intent(this, SmsActivity.class);
        startActivity(intent);
    }

    private void makeCall(String number){
        Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + number));
        startActivity(intent);
    }

}
