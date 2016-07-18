package com.example.hackeru.moviesbythread;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    public static final String MOVIE_NAME = "movie";

    private EditText searchEditText;
    private Button searchButton;

    /*
    HOME WORK:
    http://www.androidbegin.com/tutorial/jsonparsetutorial.txt
     */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        searchEditText = (EditText) findViewById(R.id.activity_main_search_edit_text);
        searchButton = (Button) findViewById(R.id.activity_main_search_button);

        searchButton.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if (v == searchButton){
            String movieName = searchEditText.getText().toString().trim();
            if (validate(movieName)){
                Intent intent = new Intent(this, ResultsActivity.class);
                intent.putExtra(MOVIE_NAME, movieName);
                startActivity(intent);
            }else{
                searchEditText.setError("WHAT??????");
            }
        }
    }

    private boolean validate(String str){
        return true;
    }
}
