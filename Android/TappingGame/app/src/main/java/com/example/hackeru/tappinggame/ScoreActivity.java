package com.example.hackeru.tappinggame;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class ScoreActivity extends AppCompatActivity implements View.OnClickListener {

    private DataSource dbSource;
    private int score;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);

        TextView scoreTextView = (TextView) findViewById(R.id.scoreTextView);
        Button saveBtn = (Button) findViewById(R.id.saveBtn);

        saveBtn.setOnClickListener(this);


        score = getIntent().getIntExtra(MainActivity.SCORE, -1);

        scoreTextView.setText("Your score is: " + score);

        dbSource = new DataSource(this);

    }

    @Override
    public void onClick(View v) {
        EditText nameEditText = (EditText) findViewById(R.id.nameEditText);
        String name = nameEditText.getText().toString().trim();
        dbSource.insertData(name, score);
        Intent intent = new Intent(this, WallOfFameActivity.class);
        startActivity(intent);
    }

    @Override
    protected void onResume() {
        super.onResume();
        dbSource.open();
    }

    @Override
    protected void onPause() {
        super.onPause();
        dbSource.close();
    }
}
