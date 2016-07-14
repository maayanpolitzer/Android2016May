package com.example.hackeru.moviesbythread;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by hackeru on 7/14/2016.
 */
public class Movie {

    private String title;
    private String poster;
    private String year;

    public Movie(String title, String year, String poster){
        this.title = title;
        this.year = year;
        this.poster = poster;
    }

    public Movie(JSONObject object){
        try {
            title = object.getString("Title");
            year = object.getString("Year");
            poster = object.getString("Poster");
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }

    @Override
    public String toString() {
        return title;
    }

    public String getTitle() {
        return title;
    }

    public String getYear() {
        return year;
    }

    public String getPoster() {
        return poster;
    }
}
