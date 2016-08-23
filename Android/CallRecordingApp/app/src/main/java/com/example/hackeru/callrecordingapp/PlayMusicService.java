package com.example.hackeru.callrecordingapp;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Binder;
import android.os.Handler;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.widget.Toast;

/**
 * Created by hackeru on 8/22/2016.
 */
public class PlayMusicService extends Service implements MediaPlayer.OnCompletionListener {

    // TODO: 8/22/2016 DONT FORGET DECLARE THE SERVICE IN THE MANIFEST FILE!!!

    private IBinder binder = new MyBinder();
    private int song;
    private MediaPlayer player;

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        song = intent.getIntExtra(CallDetailActivity.SONG, -1);
        player = MediaPlayer.create(this, song);
        player.setOnCompletionListener(this);
        return binder;
    }

    @Override
    public void onCompletion(MediaPlayer mp) {
        Intent intent = new Intent("99fm");
        sendBroadcast(intent);
    }

    public int getSongDuration(){
        return player.getDuration();
    }

    public void updateSongTime(int newSongTime){
        player.seekTo(newSongTime);
    }

    public void startPlaying(final CallDetailActivity activity){
        player.start();

        final Handler handler = new Handler();
        new Thread(new Runnable() {
            @Override
            public void run() {
                while(activity.isPlaying()){
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            activity.updateUi(player.getCurrentPosition());
                        }
                    });
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }

    public void pausePlaying(){
        player.pause();
    }



    public class MyBinder extends Binder {
        public PlayMusicService getService(){
            return PlayMusicService.this;   // returns the pointer of this service instance.
        }
    }

}
