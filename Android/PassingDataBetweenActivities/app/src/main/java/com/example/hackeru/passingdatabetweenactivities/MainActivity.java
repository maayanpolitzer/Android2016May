package com.example.hackeru.passingdatabetweenactivities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    public static final String NAME = "name";

    private Button btn;
    private Button clearBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn = (Button) findViewById(R.id.btn);
        clearBtn = (Button) findViewById(R.id.clearBtn);

        btn.setOnClickListener(this);
        clearBtn.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        EditText nameEditText = (EditText) findViewById(R.id.nameEditText);
        if (v == btn) {
            String name = nameEditText.getText().toString().trim(); //  "      maayan     "; "maayan"
            if (stringValidation(name)) {
                Intent intent = new Intent(this, SecondActivity.class);
                intent.putExtra(NAME, name);
                startActivity(intent);
            }else{
                 nameEditText.setError("Try again...");
            }
        }else if(v == clearBtn){
            nameEditText.setText("");
            //nameEditText.getText().clear();
        }

    }

    private boolean stringValidation(String str){
        if (str == null || str.isEmpty()){
            return false;
        }
        return true;
    }

}
