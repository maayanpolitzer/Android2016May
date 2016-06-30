package com.example.hackeru.memorygameadvanced;

import android.os.Handler;
import android.widget.ImageView;

/**
 * Created by hackeru on 6/30/2016.
 */
public class FlipCardThread extends Thread {

    private ImageView clickedCard;
    private ImageView firstCard;
    private Handler handler;
    private boolean working;

    public FlipCardThread(ImageView clickedCard, ImageView firstCard){
        this.clickedCard = clickedCard;
        this.firstCard = firstCard;
        handler = new Handler();
    }

    @Override
    public void run() {
        working = true;
        try {
            sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        handler.post(new Runnable() {
            @Override
            public void run() {
                clickedCard.setImageResource(R.drawable.card);
                firstCard.setImageResource(R.drawable.card);
            }
        });
        working = false;
    }

    public boolean isWorking() {
        return working;
    }
}
