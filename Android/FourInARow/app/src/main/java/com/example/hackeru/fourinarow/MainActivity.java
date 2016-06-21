package com.example.hackeru.fourinarow;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private int counter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void changeText(View view) {
        //Toast.makeText(this, "called!!!", Toast.LENGTH_LONG).show();
        /*
        TextView myText = (TextView) findViewById(R.id.asher);
        myText.setText("ma she ba li");
        */
        Button btn = (Button) findViewById(R.id.btn);
        btn.setText(++counter + "");

    }
}
