package com.example.hackeru.checkboxratingsystem2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private LinearLayout layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        layout = (LinearLayout) findViewById(R.id.layout);

        for (int i = 1; i <= 5 ;i++){
            CheckBox cb = (CheckBox) layout.findViewWithTag(i + "");
            cb.setOnClickListener(this);
        }

    }

    @Override
    public void onClick(View v) {
        int index = Integer.parseInt(v.getTag().toString());
        for (int i = 1; i <= 5; i++){
            CheckBox cb = (CheckBox) layout.findViewWithTag(i + "");
            if (i <= index){
                cb.setChecked(true);
            }else{
                cb.setChecked(false);
            }
        }
    }
}
