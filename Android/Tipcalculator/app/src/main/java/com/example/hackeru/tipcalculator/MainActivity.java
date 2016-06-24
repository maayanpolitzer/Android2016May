package com.example.hackeru.tipcalculator;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener, View.OnClickListener {

    private Button calculateBtn;
    private RadioGroup radioGroup;
    private int tipPercent;
    private EditText tipET;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        radioGroup = (RadioGroup) findViewById(R.id.radio_group);
        calculateBtn = (Button) findViewById(R.id.btn);
        tipET = (EditText) findViewById(R.id.tipET);

        radioGroup.setOnCheckedChangeListener(this);
        calculateBtn.setOnClickListener(this);


    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        if (checkedId == R.id.firstRadioButton) {
            tipPercent = 10;
            tipET.setVisibility(View.INVISIBLE);
        } else if (checkedId == R.id.secondRadioButton) {
            tipPercent = 20;
            tipET.setVisibility(View.INVISIBLE);
        } else {
            tipPercent = 0;
            tipET.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public void onClick(View v) {
        hideKeyboard();
        EditText priceET = (EditText) findViewById(R.id.priceET);
        double price = Double.parseDouble(priceET.getText().toString());
        if (tipPercent == 0) {
            // take tip from editText...
            double tip = Double.parseDouble(tipET.getText().toString());
            calculateTip(price, tip);
        } else {
            calculateTip(price, tipPercent);
        }
    }

    private void hideKeyboard() {
        InputMethodManager inputManager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        inputManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
    }

    private void calculateTip(double price, double tip) {
        double calculatedTip = price * (tip / 100);
        Toast.makeText(this, "Your tip is: " + calculatedTip, Toast.LENGTH_SHORT).show();
    }
}
