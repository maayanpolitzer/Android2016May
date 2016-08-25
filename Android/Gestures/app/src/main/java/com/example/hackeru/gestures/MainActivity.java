package com.example.hackeru.gestures;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity {

    private RelativeLayout mainLayout;

    private final int BALL_SIZE = 200;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(BALL_SIZE, BALL_SIZE);

        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);   // command to hide the status bar.

        mainLayout = (RelativeLayout) findViewById(R.id.mainLayout);
        ImageView ball = new ImageView(this);
        ball.setImageResource(R.drawable.ball);
        mainLayout.addView(ball, params);

    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Log.d("TAG", event.toString());

        return true;
    }
}
