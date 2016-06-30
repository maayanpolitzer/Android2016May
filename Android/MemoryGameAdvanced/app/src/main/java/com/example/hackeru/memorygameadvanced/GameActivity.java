package com.example.hackeru.memorygameadvanced;

import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

public class GameActivity extends AppCompatActivity implements View.OnClickListener {

    private GameOptions[] gameOptions = {
            new GameOptions(4,3),
            new GameOptions(6,4),
            new GameOptions(8,6)
    };

    private int[] images = {R.drawable.one, R.drawable.two, R.drawable.three,
            R.drawable.four, R.drawable.five, R.drawable.six};

    private int[] positions = {0,0,1,1,2,2,3,3,4,4,5,5};

    private LinearLayout mainLayout;
    private int counter;
    private int firstCardTag;
    private FlipCardThread thread;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        int tag = getIntent().getIntExtra(MainActivity.TAG, -1);

        mainLayout = (LinearLayout) findViewById(R.id.activity_game_main_layout);

        shuffle();

        displayCards(tag);

    }

    private void shuffle(){
        Random r = new Random();
        int temp = 0;
        for (int i = 0; i < positions.length; i++){
            int random = r.nextInt(positions.length);
            temp = positions[random];
            positions[random] = positions[i];
            positions[i] = temp;
        }
    }

    private void displayCards(int index){
        int tag = 0;
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                        ViewGroup.LayoutParams.MATCH_PARENT,
                        ViewGroup.LayoutParams.MATCH_PARENT,
                        1);
        for (int i = 0; i < gameOptions[index].getRows(); i++){
            LinearLayout row = new LinearLayout(this);
            for (int j = 0; j < gameOptions[index].getColumns(); j++) {
                ImageView cardImageView = new ImageView(this);
                cardImageView.setTag(tag++);
                cardImageView.setImageResource(R.drawable.card);
                cardImageView.setOnClickListener(this);
                row.addView(cardImageView, params);
            }
            mainLayout.addView(row, params);
        }
    }

    @Override
    public void onClick(View v) {
        if (thread == null || !thread.isWorking()) {
            counter++;
            ImageView clickedCard = (ImageView) v;
            int tag = Integer.parseInt(clickedCard.getTag().toString());
            clickedCard.setImageResource(images[positions[tag]]);
            if (counter % 2 == 0) {
                // check cards...
                ImageView firstCard = (ImageView) mainLayout.findViewWithTag(firstCardTag);
                if (positions[tag] == positions[firstCardTag]) {
                    // the same!!!!
                    clickedCard.setOnClickListener(null);
                    firstCard.setOnClickListener(null);
                } else {
                    // NOT the same... flip them
                    thread = new FlipCardThread(clickedCard, firstCard);
                    thread.start();
                }
            } else {
                // only one card
                firstCardTag = tag;
            }
        }
    }
}
