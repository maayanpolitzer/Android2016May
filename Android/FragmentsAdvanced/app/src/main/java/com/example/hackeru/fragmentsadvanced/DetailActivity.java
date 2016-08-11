package com.example.hackeru.fragmentsadvanced;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        /*
        String name = getIntent().getExtras().getString(MainActivity.NAME);
        Toast.makeText(this, "You clicked on: " + name, Toast.LENGTH_SHORT).show();
        */

        DetailFragment fragment = new DetailFragment();
        Bundle bundle = getIntent().getExtras();
        fragment.setArguments(bundle);
        getFragmentManager()
                .beginTransaction()
                .add(R.id.activity_detail_container, fragment)
                .commit();
    }
}
