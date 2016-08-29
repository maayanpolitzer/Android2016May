package com.example.hackeru.gesturedetector;

import android.os.Handler;
import android.support.v4.view.GestureDetectorCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity {

    private GestureDetectorCompat detector;

    private RelativeLayout mainLayout;
    private final int BALL_SIZE = 200;

    private int LEFT_BORDER = 0;
    private int TOP_BORDER = 0;
    private int RIGHT_BORDER;
    private int BOTTOM_BORDER;

    private boolean dragging;
    private ImageView ball;

    private float vX;
    private float vY;

    private float x;
    private float y;

    private RelativeLayout.LayoutParams params;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);

        mainLayout = (RelativeLayout) findViewById(R.id.mainLayout);

        DisplayMetrics metrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(metrics);
        RIGHT_BORDER = metrics.widthPixels;
        BOTTOM_BORDER = metrics.heightPixels;

        ball = new ImageView(this);
        ball.setImageResource(R.drawable.ball);

        params = new RelativeLayout.LayoutParams(BALL_SIZE, BALL_SIZE);
        mainLayout.addView(ball, params);

        detector = new GestureDetectorCompat(this, new GestureDetector.OnGestureListener() {
            @Override
            public boolean onDown(MotionEvent e) {
                return false;
            }

            @Override
            public void onShowPress(MotionEvent e) {

            }

            @Override
            public boolean onSingleTapUp(MotionEvent e) {
                return false;
            }

            @Override
            public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
                return false;
            }

            @Override
            public void onLongPress(MotionEvent e) {

            }

            @Override
            public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
                Log.d("TAG", "vX:" + velocityX + ", vY:" + velocityY);
                if (dragging){
                    dragging = false;
                    vX = velocityX * 0.001f;
                    vY = velocityY * 0.001f;
                    final Handler handler = new Handler();
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            while(vX != 0 || vY != 0){
                                vX *= 0.99f;
                                vY *= 0.99f;
                                x += vX;
                                y += vY;
                                if (Math.abs(vX) < 0.1){
                                    vX = 0;
                                }
                                if (Math.abs(vY) < 0.1){
                                    vY = 0;
                                }
                                if (x <= LEFT_BORDER){
                                    x = 0;
                                    vX *= -1;
                                }
                                if (x >= RIGHT_BORDER){
                                    x = RIGHT_BORDER - 400;
                                    vX *= -1;
                                }
                                if (y >= BOTTOM_BORDER){
                                    y = BOTTOM_BORDER - 400;
                                    vY *= -1;
                                }
                                if (y <= TOP_BORDER){
                                    y = 0;
                                    vY *= -1;
                                }
                                handler.post(new Runnable() {
                                    @Override
                                    public void run() {
                                        params.setMargins((int) Math.round(x),(int) Math.round(y), 0, 0);
                                        ball.setLayoutParams(params);
                                    }
                                });
                                try {
                                    Thread.sleep(1);
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }
                            }
                        }
                    }).start();

                }
                return true;
            }
        });

    }   // onCreate end...

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Log.d("TAG", "onTouch()");
        switch(event.getAction()){
            case MotionEvent.ACTION_DOWN:
                if (event.getX() >= ball.getX() && event.getX() <= (ball.getX() + BALL_SIZE) &&
                        event.getY() >= ball.getY() && event.getY() <= (ball.getY() + BALL_SIZE)){
                    dragging = true;
                }
                break;
            case MotionEvent.ACTION_MOVE:
                if (dragging){
                    x = event.getX();
                    y = event.getY();
                    params.setMargins((int) x, (int) y, 0, 0);
                    ball.setLayoutParams(params);
                }
                break;
        }
        detector.onTouchEvent(event);
        return true;
    }
}
