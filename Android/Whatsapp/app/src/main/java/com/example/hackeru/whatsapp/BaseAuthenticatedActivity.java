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
        return true;
    }

    protected abstract void onLoggedIn(Bundle savedInstanceState);

}
