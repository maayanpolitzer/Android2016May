package com.example.hackeru.sharedprefrences;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btn;
    public static SharedPreferences settings;         // get
    private static SharedPreferences.Editor editor;    // put

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        settings = getSharedPreferences("mySavedStuff", MODE_PRIVATE);
        editor = settings.edit();

        if (settings.contains("USERNAME")){
            login();
        }

        btn = (Button) findViewById(R.id.btn);
        btn.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        EditText username = (EditText) findViewById(R.id.usernameEditText);
        String user = username.getText().toString().trim();
        if (validate(user)){
            editor.putString("USERNAME", user);
            editor.putInt("age", 45);
            editor.putBoolean("isMale", true);
            editor.commit();    // DON'T FORGET THIS LINE!!!
            login();
        }
    }

    private void login(){
        Intent intent = new Intent(this, ListActivity.class);
        startActivity(intent);
    }

    private boolean validate(String str){
        if (str.isEmpty()){
            return false;
        }
        return true;
    }
}
