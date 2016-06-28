package com.example.hackeru.sendingdatabacktoactivity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button setNameBtn;
    private static final int SET_NAME_REQUST_CODE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setNameBtn = (Button) findViewById(R.id.activity_main_set_name_button);

        setNameBtn.setOnClickListener(this);

    }


    @Override
    public void onClick(View v) {
        if (v == setNameBtn){
            Intent intent = new Intent(this, SecondActivity.class);
            startActivityForResult(intent, SET_NAME_REQUST_CODE);

        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == SET_NAME_REQUST_CODE){
            if (resultCode == RESULT_OK){
                //Toast.makeText(this, "change text...", Toast.LENGTH_LONG).show();
                String name = data.getStringExtra(SecondActivity.NAME);
                if (name != null){
                    TextView nameTextView = (TextView) findViewById(R.id.activity_main_name_text_view);
                    nameTextView.setText("Hello : " + name);
                }
            }else if (resultCode == RESULT_CANCELED){
                Toast.makeText(this, "canceled!!!", Toast.LENGTH_LONG).show();
            }
        }
    }
}
