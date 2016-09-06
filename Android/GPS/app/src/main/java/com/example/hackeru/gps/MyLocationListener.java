package com.example.hackeru.gps;

import android.content.Context;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationProvider;
import android.os.Bundle;
import android.util.Log;

import java.io.IOException;
import java.util.List;

/**
 * Created by hackeru on 9/5/2016.
 */
public class MyLocationListener implements LocationListener {

    private Location maayansHome;

    public MyLocationListener(Context context){
        maayansHome = new Location("WHY????????");
        maayansHome.setLongitude(34.996334f);
        maayansHome.setLatitude(32.238916f);
        Geocoder coder = new Geocoder(context);
        try {
            List<Address> addressList = coder.getFromLocation(maayansHome.getLatitude(), maayansHome.getLongitude(), 10);
            for (Address a : addressList){
                Log.d("TAG", a.toString());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onLocationChanged(Location location) {
        // this method will be called when the app gets a location update.
        Log.d("TAG", "The location is: " + location);
        float distanceToHome = location.distanceTo(maayansHome);
        Log.d("TAG", "your distance from home is: " + distanceToHome + " meters");



    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {
        switch(status){
            case LocationProvider.AVAILABLE:
                Log.d("TAG", provider + " available!");
                break;
            case LocationProvider.OUT_OF_SERVICE:
                Log.d("TAG", provider + " out of service");
                break;
            case LocationProvider.TEMPORARILY_UNAVAILABLE:
                Log.d("TAG", provider + " temporarily unavailable");
                break;
        }
    }

    @Override
    public void onProviderEnabled(String provider) {
        Log.d("TAG", provider + " enabled!");
    }

    @Override
    public void onProviderDisabled(String provider) {
        Log.d("TAG", provider + " DISABLED!");
    }
}
