package com.example.hackeru.volleymovies;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class ResultsActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);

        ListFragment fragment = new ListFragment();
        fragment.setArguments(getIntent().getExtras());

        getFragmentManager()
                .beginTransaction()
                .add(R.id.list_container, fragment)
                .commit();


        /*  old fashion...
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    URL url = new URL(link + movieName);
                    HttpURLConnection con = (HttpURLConnection) url.openConnection();
                    BufferedReader reader = new BufferedReader(new InputStreamReader(con.getInputStream()));
                    String data = "";
                    String line;
                    while ((line = reader.readLine()) != null){
                        data += line;
                    }
                    JsonObject response = new JsonObject(data);

                } catch (MalformedURLException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        */
    }



}
