package com.example.hackeru.memorygame;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    int[] images = {R.drawable.one, R.drawable.two, R.drawable.three,
                    R.drawable.four, R.drawable.five, R.drawable.six};

    int[] position = {0,4,1,1,2,2,5,3,4,3,0,5}; // random...

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LinearLayout mainLayout = (LinearLayout) findViewById(R.id.mainLayout);
        //mainLayout.setBackgroundColor(Color.parseColor("#ff0000"));
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT, 1);

        int counter = 0;

        for (int i = 0; i < 4; i++) {
            LinearLayout row = new LinearLayout(this);
            //row.setOrientation(LinearLayout.HORIZONTAL);    // this is the default...
            for (int j = 0; j < 3; j++) {
                ImageView imageView = new ImageView(this);
                imageView.setImageResource(R.drawable.card);
                imageView.setOnClickListener(this);
                imageView.setTag(counter++);
                row.addView(imageView, params);
            }
            mainLayout.addView(row, params);
        }
    }

    @Override
    public void onClick(View v) {
        //Toast.makeText(this, v.getId() + "", Toast.LENGTH_SHORT).show();
        ImageView clickedCard = (ImageView) v;
        int tag = Integer.parseInt(v.getTag().toString());
        int index = position[tag];
        clickedCard.setImageResource(images[index]);

        if (checkCards(clickedCard, lastCard)){
            // they are the same.
        }else{
            // need to wait for 2 second and flip them.
            new FlipCardsThread(clickedCard, lastCard).start();
        }
    }
}
