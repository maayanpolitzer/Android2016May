package com.example.hackeru.memorygame;

import android.os.Handler;
import android.widget.ImageView;

/**
 * Created by hackeru on 6/27/2016.
 */
public class FlipCardsThread extends Thread {

    private ImageView clickedCard;
    private ImageView lastCard;
    private final int DELAY_TIME = 2000; // milliseconds...
    Handler handler;

    public FlipCardsThread(ImageView clickedCard, ImageView lastCard){
        this.clickedCard = clickedCard;
        this.lastCard = lastCard;
        handler = new Handler();
    }

    @Override
    public void run() {
        try {
            sleep(DELAY_TIME);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        handler.post(new Runnable() {
            @Override
            public void run() {
                clickedCard.setImageResource(R.drawable.card);
                lastCard.setImageResource(R.drawable.card);
            }
        });
    }
}
