package com.example.hackeru.callrecordingapp.recording;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.media.MediaRecorder;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.support.v7.app.NotificationCompat;

import com.example.hackeru.callrecordingapp.CallDetailActivity;
import com.example.hackeru.callrecordingapp.R;
import com.example.hackeru.callrecordingapp.infrastructure.Call;
import com.example.hackeru.callrecordingapp.infrastructure.RecordingTableConnector;

import java.io.IOException;

/**
 * Created by hackeru on 8/18/2016.
 */
public class RecordingService extends Service {

    // TODO: 8/18/2016 dont forget declare the service in the MANIFEST file.

    private MediaRecorder recorder;
    private Call call;
    private String phoneNumber;
    private int state;

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        phoneNumber = intent.getStringExtra(PhoneListener.PHONE_NUMBER);
        state = intent.getIntExtra(PhoneListener.STATE, -1);
        startRecording();
        return START_NOT_STICKY;            // android will not restart this service if it will be destroyed.
        //return START_STICKY;              // android will restart to this service.
        //return START_REDELIVER_INTENT;    // android will restart this service, and will redeliver the intent.
    }

    private void startRecording(){
        call = new Call(state, phoneNumber, "flgjndf");
        /*
        recorder = new MediaRecorder();
        // TODO: 8/22/2016 voice recording permission!!!!
        recorder.setAudioSource(MediaRecorder.AudioSource.VOICE_CALL);
        recorder.setOutputFormat(MediaRecorder.OutputFormat.MPEG_4);
        recorder.setOutputFile(filePath);
        recorder.setAudioEncoder(MediaRecorder.AudioEncoder.AAC);
        try {
            recorder.prepare();
            recorder.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
        */
    }

    private void stopRecording(){
        call.setEnd();
        RecordingTableConnector dbConnector = new RecordingTableConnector(this);
        dbConnector.insert(call);
        /*
        recorder.stop();
        recorder.release();
        */
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        stopRecording();
        sendNotification(234);
    }


    // because we are firing this service by startService() and NOT bindService() - > onBind returns null.
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    private void sendNotification(int length){
        Intent intent = new Intent(this, CallDetailActivity.class);
        intent.putExtra(CallDetailActivity.SONG, R.raw.song);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 2345, intent, PendingIntent.FLAG_UPDATE_CURRENT);

        NotificationCompat.Builder builder = new NotificationCompat.Builder(this);
        builder.setContentTitle("Call recorded!");
        builder.setContentText("call length: " + length);
        builder.setSmallIcon(android.R.drawable.ic_menu_call);
        builder.setContentIntent(pendingIntent);

        NotificationManager manager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE); // get the manager pointer
        manager.notify(120, builder.build());   // execute! display the notification.
    }


}
