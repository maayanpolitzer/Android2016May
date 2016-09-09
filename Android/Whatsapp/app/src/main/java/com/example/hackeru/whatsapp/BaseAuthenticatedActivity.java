package com.example.hackeru.whatsapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;

/**
 * Created by hackeru on 8/29/2016.
 */
public abstract class BaseAuthenticatedActivity extends BaseActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if(!userExists()){
            finish();
            Intent intent = new Intent(this, LoginActivity.class);
            startActivity(intent);
            return; // stop the onCreate method!!!
        }
        onLoggedIn(savedInstanceState);

    }

    private boolean userExists(){
        return settings.getInt(BaseActivity.USER_ID, -1) != -1; // check if user exists... return -1 if NOT!!!!
    }

    protected abstract void onLoggedIn(Bundle savedInstanceState);

}
