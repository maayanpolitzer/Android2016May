package com.example.hackeru.callrecordingapp;

import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
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

import java.text.SimpleDateFormat;

public class CallDetailActivity extends AppCompatActivity implements View.OnClickListener, SeekBar.OnSeekBarChangeListener {

    private int song;
    public static final String SONG = "song";
    private ImageView playBtn;
    private SeekBar seekbar;
    private TextView currentDurationTV;
    private TextView totalDurationTV;
    private PlayMusicService playService;
    private boolean isBound;
    private boolean isPlaying;
    private BroadcastReceiver receiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            isPlaying = false;
            playBtn.setImageResource(android.R.drawable.ic_media_play);
            seekbar.setProgress(0);
            currentDurationTV.setText(convertMilliToString(0));
        }
    };

    private ServiceConnection serviceConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            PlayMusicService.MyBinder binder = (PlayMusicService.MyBinder) service;
            playService = binder.getService();
            isBound = true;

            songDuration = playService.getSongDuration();
            totalDurationTV.setText(convertMilliToString(songDuration));
            seekbar.setMax(songDuration);
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            isBound = false;
        }
    };

    private int songDuration;

    private String convertMilliToString(int millisecond){
        int duration = millisecond;
        duration /= 1000;
        int minutes = duration / 60;
        int seconds = duration % 60;
        return (minutes > 9 ? minutes : "0" + minutes) + ":" + (seconds > 9 ? seconds : "0" + seconds);
    }

    public boolean isPlaying(){
        return isPlaying;
    }

    public void updateUi(int currentPosition){
        currentDurationTV.setText(convertMilliToString(currentPosition));
        /*
        double percent = (double)currentPosition / (double)songDuration;
        Log.d("TAG", "percent: " + percent);
        seekbar.setProgress((int)Math.round(percent * 100));
        */
        seekbar.setProgress(currentPosition);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_call_detail);

        song = getIntent().getIntExtra(SONG, -1);

        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);   // prevent from calling onPause by itself...

        playBtn = (ImageView) findViewById(R.id.activity_call_detail_play_button);
        seekbar = (SeekBar) findViewById(R.id.activity_call_detail_seekbar);
        currentDurationTV = (TextView) findViewById(R.id.activity_call_detail_current_duration_text_view);
        totalDurationTV = (TextView) findViewById(R.id.activity_call_detail_total_duration_text_view);

        playBtn.setOnClickListener(this);
        seekbar.setOnSeekBarChangeListener(this);

        NotificationManager manager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        manager.cancel(120);


    }

    @Override
    protected void onResume() {
        super.onResume();
        // bind the service to the activity.
        Intent intent = new Intent(this, PlayMusicService.class);
        intent.putExtra(SONG, song);
        bindService(intent, serviceConnection, BIND_AUTO_CREATE);
        IntentFilter filter = new IntentFilter("99fm");
        registerReceiver(receiver, filter);
    }

    @Override
    protected void onPause() {
        super.onPause();
        // unbind the service from the activity.
        unbindService(serviceConnection);
        unregisterReceiver(receiver);
    }

    @Override
    public void onClick(View v) {
        if (v == playBtn){
            if (isBound){
                if (!isPlaying){
                    playService.startPlaying(this);
                    playBtn.setImageResource(android.R.drawable.ic_media_pause);
                }else{
                    playService.pausePlaying();
                    playBtn.setImageResource(android.R.drawable.ic_media_play);
                }
                isPlaying = !isPlaying;
            }
        }
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        currentDurationTV.setText(convertMilliToString(progress));
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {
        playService.updateSongTime(seekbar.getProgress());
    }
}
