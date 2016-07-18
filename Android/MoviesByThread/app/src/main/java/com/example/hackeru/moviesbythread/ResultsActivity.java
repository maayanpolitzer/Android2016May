package com.example.hackeru.moviesbythread;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class ResultsActivity extends AppCompatActivity implements DownloadCompletedListener {

    private ListView listView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);

        listView = (ListView) findViewById(R.id.listView);

        String movieName = getIntent().getStringExtra(MainActivity.MOVIE_NAME);
        String link = "http://www.omdbapi.com/?s=" + movieName + "&r=json";

        DownloadThread thread = new DownloadThread(this, link);
        thread.start();

        // learn about infinite scroll...


    }

    public void displayList(ArrayList<Movie> moviesList){
        //ArrayAdapter<Movie> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,moviesList);
        MoviesAdapter adapter = new MoviesAdapter(this, moviesList);
        listView.setAdapter(adapter);
    }

}
