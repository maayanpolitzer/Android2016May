package com.example.hackeru.whatsapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class RegisterActivity extends BaseActivity implements View.OnClickListener, OnRegisterCompleted {

    private Button registerBtn;
    private EditText conPasswordET, passwordET, nameET, emailET;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        registerBtn = (Button) findViewById(R.id.activity_register_btn);

        registerBtn.setOnClickListener(this);

    }


    @Override
    public void onClick(View v) {
        emailET = (EditText) findViewById(R.id.activity_register_email);
        nameET = (EditText) findViewById(R.id.activity_register_name);
        passwordET = (EditText) findViewById(R.id.activity_register_password);
        conPasswordET = (EditText) findViewById(R.id.activity_register_con_password);

        String email = emailET.getText().toString();
        String name = nameET.getText().toString();
        String password = passwordET.getText().toString();
        String conPassword = conPasswordET.getText().toString();

        if (validate(email, name, password, conPassword)){
            new RegisterThread(this, email, name, password).start();
        }
    }

    @Override
    public void login(int userID) {
        Log.d("TAG", "userID: " + userID);
        editor.putInt(BaseActivity.USER_ID, userID);
        editor.commit();
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }

    private boolean validate(String email, String name, String password, String conPassword){
        boolean valid = true;
        if (email.isEmpty() || !email.contains("@") || !email.contains(".")){
            valid = false;
            emailET.setError("Problem");
        }
        if (name.isEmpty()){
            valid = false;
            nameET.setError("Problem");
        }
        if (!password.equals(conPassword)){
            valid = false;
            conPasswordET.setError("Problem");
        }
        return valid;
    }

}

interface OnRegisterCompleted {
    void login(int userID);
}
