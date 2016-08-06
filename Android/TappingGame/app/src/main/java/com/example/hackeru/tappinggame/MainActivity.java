package com.example.hackeru.tappinggame;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    public static final String SCORE = "kjhkjbn";
    private Button btn;
    private int counter;
    private boolean playing = false;
    private Handler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        handler = new Handler();

        btn = (Button) findViewById(R.id.btn);

        btn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (!playing){
            playing = true;
            startTimer();
        }else{
            counter++;
        }

    }

    private void startTimer(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 5; i > 0; i--){
                    final int finalI = i;
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            btn.setText(finalI + "");
                        }
                    });
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                moveToScoreActivity();
            }
        }).start();
    }

    private void moveToScoreActivity(){
        Intent intent = new Intent(this, ScoreActivity.class);
        intent.putExtra(SCORE, counter);
        startActivity(intent);
    }

}
