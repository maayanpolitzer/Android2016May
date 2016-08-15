package com.example.hackeru.volleymovies;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by hackeru on 8/15/2016.
 */
public class Movie {

    private String title, poster, id;

    public Movie(JSONObject object){
        try {
            title = object.getString("Title");
            id = object.getString("imdbID");
            poster = object.getString("Poster");
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public String getTitle() {
        return title;
    }

    public String getPoster() {
        return poster;
    }

    public String getId() {
        return id;
    }
}
