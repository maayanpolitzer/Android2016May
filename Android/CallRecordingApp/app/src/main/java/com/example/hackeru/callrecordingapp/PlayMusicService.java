package com.example.hackeru.callrecordingapp;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Binder;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.widget.Toast;

/**
 * Created by hackeru on 8/22/2016.
 */
public class PlayMusicService extends Service {

    // TODO: 8/22/2016 DONT FORGET DECLARE THE SERVICE IN THE MANIFEST FILE!!!

    private IBinder binder = new MyBinder();
    private int song;
    private MediaPlayer player;

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        song = intent.getIntExtra(CallDetailActivity.SONG, -1);
        player = MediaPlayer.create(this, song);
        return binder;
    }

    public int getSongDuration(){
        return player.getDuration();
    }

    public void startPlaying(){


        player.start();
    }

    public class MyBinder extends Binder {
        public PlayMusicService getService(){
            return PlayMusicService.this;   // returns the pointer of this service instance.
        }
    }

}
