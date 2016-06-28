package com.example.hackeru.sendingdatabacktoactivity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity implements View.OnClickListener {

    private Button backBtn;
    public static final String NAME = "name";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        backBtn = (Button) findViewById(R.id.activity_second_back_button);

        backBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v == backBtn){
            EditText nameEditText = (EditText) findViewById(R.id.activity_second_name_edit_text);
            String name = nameEditText.getText().toString();
            if (!name.isEmpty()){
                //Toast.makeText(this, "your name is: " + name, Toast.LENGTH_SHORT).show();
                Intent infoIntent = new Intent();
                infoIntent.putExtra(NAME, name);
                setResult(RESULT_OK, infoIntent);
                finish();
            }
        }
    }
}
