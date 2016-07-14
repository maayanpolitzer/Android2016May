package com.example.hackeru.moviesbythread;

import android.os.Handler;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

/**
 * Created by hackeru on 7/14/2016.
 */
public class DownloadThread extends Thread {

    //private ResultActivity activity;
    private DownloadCompletedListener activity;
    private String link;
    private Handler handler;


    //public DownloadThread(ResultActivity activity, String link){
    public DownloadThread(DownloadCompletedListener activity, String link){
        this.activity = activity;
        this.link = link;
        handler = new Handler();
    }

    @Override
    public void run() {
        try {
            URL url = new URL(link);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String data = "";
            String line;
            while((line = reader.readLine()) != null){
                data += line;
            }
            convertStringToList(data);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void convertStringToList(String jsonString){
        final ArrayList<Movie> movies = new ArrayList<>();
        try {
            JSONObject mainObject = new JSONObject(jsonString);
            JSONArray arr = mainObject.getJSONArray("Search");
            for (int i = 0; i < arr.length(); i++){
                /*
                JSONObject object = arr.getJSONObject(i);
                String title = object.getString("Title");
                String year = object.getString("Year");
                String poster = object.getString("Poster");
                Movie movie = new Movie(title, year, poster);
                movies.add(movie);
                */
                movies.add(new Movie(arr.getJSONObject(i)));
            }
            handler.post(new Runnable() {
                @Override
                public void run() {
                    activity.displayList(movies);
                }
            });
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

}
