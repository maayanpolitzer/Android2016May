package com.example.hackeru.gps;

import android.content.Context;
import android.content.Intent;
import android.location.Criteria;
import android.location.LocationManager;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    private LocationManager manager;
    private String provider;
    private MyLocationListener locationListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        manager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);// get the location manager pointer.
        Criteria criteria = new Criteria(); // get us the best provider (GPS or WIFI).
        provider = manager.getBestProvider(criteria, false);    // false = check all options, true - check all ENABLED options.
        locationListener = new MyLocationListener(this);

        if (!manager.isProviderEnabled(LocationManager.GPS_PROVIDER)){
            Intent intent = new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
            startActivity(intent);
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        // start request for locations...
        if (manager != null){
            manager.requestLocationUpdates(provider, 1000, 1, locationListener);
        }

    }

    @Override
    protected void onPause() {
        super.onPause();
        // stop requsts...
        manager.removeUpdates(locationListener);
    }
}
