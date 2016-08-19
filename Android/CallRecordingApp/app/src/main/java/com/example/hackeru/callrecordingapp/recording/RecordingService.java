package com.example.hackeru.callrecordingapp.recording;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;

/**
 * Created by hackeru on 8/18/2016.
 */
public class RecordingService extends Service {

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        String phoneNumber = intent.getStringExtra(PhoneListener.PHONE_NUMBER);
        int state = intent.getIntExtra(PhoneListener.STATE, -1);
        return START_NOT_STICKY;            // android will not restart this service if it will be destroyed.
        //return START_STICKY;              // android will restart to this service.
        //return START_REDELIVER_INTENT;    // android will restart this service, and will redeliver the intent.
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    // TODO: 8/18/2016 dont forget declare the service in the MANIFEST file.
}
