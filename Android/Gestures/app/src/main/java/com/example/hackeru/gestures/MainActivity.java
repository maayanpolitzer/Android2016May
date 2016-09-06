package com.example.hackeru.gestures;

import android.os.Handler;
import android.support.v4.view.GestureDetectorCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private RelativeLayout mainLayout;

    private final int BALL_SIZE = 200;

    private boolean dragging;

    private ImageView ball;
    private RelativeLayout.LayoutParams params;

    private float fixX, fixY;
    private int topBorder = 0;
    private int leftBorder = 0;
    private int bottomBorder;
    private int rightBorder;

    private View view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*
        DisplayMetrics metrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(metrics);
        rightBorder = metrics.widthPixels;
        bottomBorder = metrics.heightPixels;
        Log.d("TAG", "height: " + topBorder + "," + bottomBorder + ", width: " + leftBorder + "," + rightBorder);
        */

        params = new RelativeLayout.LayoutParams(BALL_SIZE, BALL_SIZE);

        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);   // command to hide the status bar.

        mainLayout = (RelativeLayout) findViewById(R.id.mainLayout);
        view = findViewById(R.id.view);

        //Log.d("TAG", "layout height: " + mainLayout.getHeight() + " width: " + mainLayout.getWidth());    // can't call that on onCreate because the view isn't display yet...

        ball = new ImageView(this);
        ball.setImageResource(R.drawable.ball);
        mainLayout.addView(ball, params);



    }



    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch(event.getAction()){
            case MotionEvent.ACTION_DOWN:
                // touched the screen.
                if(event.getX() >= ball.getX() && event.getX() <= (ball.getX() + ball.getWidth()) &&
                         event.getY() >= ball.getY() && event.getY() <= (ball.getY() + ball.getHeight())){
                    dragging = true;
                    fixX = event.getX() - ball.getX();
                    fixY = event.getY() - ball.getY();
                    Log.d("TAG", "fixX: " + fixX + ", fixY: " + fixY);
                }
                break;
            case MotionEvent.ACTION_MOVE:
                // move my finger on the screen.
                if (dragging){
                    // move the ball!.
                    ball.setX(event.getX() - fixX);
                    ball.setY(event.getY() - fixY);
                }

                break;
            case MotionEvent.ACTION_UP:
                // stop touching the screen.
                if (dragging){
                    dragging = false;
                    if(ball.getX() >= view.getX() && ball.getX() <= (view.getX() + view.getWidth()) &&
                            ball.getY() >= view.getY() && ball.getY() <= (view.getY() + view.getHeight())){
                        Toast.makeText(this, "In target", Toast.LENGTH_SHORT).show();
                    }else{
                        moveToAnchor();
                    }
                }
                break;
        }
        return true;
    }

    private void moveToAnchor(){
        final Handler handler = new Handler();
        new Thread(new Runnable() {
            @Override
            public void run() {

                while(ball.getX() > 1 || ball.getY() > 1) {
                    final float x = ball.getX() * 0.95f;
                    final float y = ball.getY() * 0.95f;
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            ball.setX(x);
                            ball.setY(y);
                        }
                    });
                    try {
                        Thread.sleep(1000/60);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }

}
