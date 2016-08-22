package com.example.hackeru.callrecordingapp;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

public class CallDetailActivity extends AppCompatActivity implements View.OnClickListener, SeekBar.OnSeekBarChangeListener {

    public static final String SONG = "song";
    private ImageView playBtn;
    private SeekBar seekbar;
    private TextView currentDurationTV;
    private TextView totalDurationTV;
    private PlayMusicService playService;
    private boolean isBound;
    private ServiceConnection serviceConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            PlayMusicService.MyBinder binder = (PlayMusicService.MyBinder) service;
            playService = binder.getService();
            isBound = true;

            totalDurationTV.setText(convertMilliToString(playService.getSongDuration()));
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            isBound = false;
        }
    };

    private String convertMilliToString(int millisecond){
        int duration = millisecond;
        duration /= 1000;
        int minutes = duration / 60;
        int seconds = duration % 60;
        return minutes + ":" + seconds;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_call_detail);

        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);   // prevent from calling onPause by itself...

        playBtn = (ImageView) findViewById(R.id.activity_call_detail_play_button);
        seekbar = (SeekBar) findViewById(R.id.activity_call_detail_seekbar);
        currentDurationTV = (TextView) findViewById(R.id.activity_call_detail_current_duration_text_view);
        totalDurationTV = (TextView) findViewById(R.id.activity_call_detail_total_duration_text_view);

        playBtn.setOnClickListener(this);
        seekbar.setOnSeekBarChangeListener(this);


    }

    @Override
    protected void onResume() {
        super.onResume();
        // bind the service to the activity.
        Intent intent = new Intent(this, PlayMusicService.class);
        intent.putExtra(SONG, R.raw.song);
        bindService(intent, serviceConnection, BIND_AUTO_CREATE);
    }

    @Override
    protected void onPause() {
        super.onPause();
        // unbind the service from the activity.
        unbindService(serviceConnection);
    }

    @Override
    public void onClick(View v) {
        if (v == playBtn){
            if (isBound){
                playService.startPlaying();
            }
        }
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }
}
