package com.example.hackeru.checkboxratingsystem;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private CheckBox[] checkBoxes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        checkBoxes = new CheckBox[5];
        checkBoxes[0] = (CheckBox) findViewById(R.id.cb1);
        checkBoxes[1] = (CheckBox) findViewById(R.id.cb2);
        checkBoxes[2] = (CheckBox) findViewById(R.id.cb3);
        checkBoxes[3] = (CheckBox) findViewById(R.id.cb4);
        checkBoxes[4] = (CheckBox) findViewById(R.id.cb5);

        for (int i = 0; i < checkBoxes.length; i++){
            checkBoxes[i].setOnClickListener(this);
        }
    }


    @Override
    public void onClick(View v) {
        for (int i = 0; i < checkBoxes.length; i++){
            if (v.getId() == checkBoxes[i].getId()){

                checkTheBoxes(i);
                break;
            }
        }
    }



    private void checkTheBoxes(int index){
        for (int i = 0; i < checkBoxes.length; i++){
            if (i <= index){
                checkBoxes[i].setChecked(true);
            }else
                checkBoxes[i].setChecked(false);
        }
    }

}
