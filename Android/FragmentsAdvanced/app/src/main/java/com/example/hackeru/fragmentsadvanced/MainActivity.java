package com.example.hackeru.fragmentsadvanced;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements OnMonsterClickListener {

    public static final String NAME = "name";
    public static final String ICON = "icon";
    public static final String MONSTER = "monster";

    private boolean isLandscape;    // default is false.

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getFragmentManager()
                .beginTransaction()
                .add(R.id.activity_main_list_container, new ListFragment())
                .commit();

        if(findViewById(R.id.activity_detail_container) != null){
            isLandscape = true;
        }

    }

    @Override
    public void changeView(Bundle data) {
        //Toast.makeText(this, data.getString(NAME), Toast.LENGTH_SHORT).show();
        if (!isLandscape) {
            Intent intent = new Intent(this, DetailActivity.class);
            intent.putExtras(data);
            startActivity(intent);
        }else{
            DetailFragment fragment = new DetailFragment();
            fragment.setArguments(data);
            getFragmentManager()
                    .beginTransaction()
                    .replace(R.id.activity_detail_container, fragment)
                    .commit();
        }
    }
}
