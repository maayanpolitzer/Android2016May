package com.example.hackeru.volleymovies;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by hackeru on 8/15/2016.
 */
public class ListFragment extends Fragment {

    private String link = "http://www.omdbapi.com/?s=";
    private Context context;
    private ListView listView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_list, null);

        listView = (ListView) view.findViewById(R.id.listView);

        String movieName = getArguments().getString(MainActivity.MOVIE_NAME);
        sendRequest(movieName);

        return view;
    }

    private void sendRequest(String movieName) {
        String movie = link + movieName;
        JsonObjectRequest request = new JsonObjectRequest(
                Request.Method.GET,
                movie,
                null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        // data arrived...
                        displayList(response);
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(context, "Error: " + error.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }
        );

        RequestQueue queue = Volley.newRequestQueue(context);
        queue.add(request);
    }

    private void displayList(JSONObject response){
        ArrayList<Movie> movies = new ArrayList<>();
        try {
            JSONArray arr = response.getJSONArray("Search");
            for (int i = 0; i < arr.length(); i++){
                movies.add(new Movie(arr.getJSONObject(i)));
                /*
                JSONObject movieJSON = arr.getJSONObject(i);
                Movie movie = new Movie(movieJSON);
                movies.add(movie);
                */
            }
            ArrayAdapter<Movie> adapter = new ArrayAdapter<Movie>(context, android.R.layout.simple_list_item_1, movies);
            listView.setAdapter(adapter);

        } catch (JSONException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.context = context;
    }
}
