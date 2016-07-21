package com.example.hackeru.fragmentsadvanced;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, HappinessChangedListener {

    private TextView textView;
    private EditText editText;
    private Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = (TextView) findViewById(R.id.textView);
        editText = (EditText) findViewById(R.id.editText);
        btn = (Button) findViewById(R.id.btn);

        btn.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        Bundle bundle = new Bundle();
        bundle.putString("NAME", editText.getText().toString());

        MyFragment fragment = new MyFragment();
        fragment.setArguments(bundle);
        fragment.show(getFragmentManager(), null);
    }

    public void setHappiness(int value){
        textView.setText("You are: " + value);
    }
}
