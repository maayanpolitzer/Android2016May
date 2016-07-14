package com.example.hackeru.json;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    String obj = "{\"name\":\"Maayan\", \"age\":30}";
    String arr = "[{\"name\":\"Maayan\", \"age\":30},{\"name\":\"Liran\", \"age\":28},{\"name\":\"Itay\", \"age\":14}]";
    String complex = "{\"students\" : [{\"name\":\"maayan\"}," +
            "{\"name\":\"Nachum\"},{\"name\":\"Doriel\"},{\"name\":\"Tom\"}]}";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*
        // get Json object:
        try {
            JSONObject json = new JSONObject(obj);
            String myName = json.getString("name");
            int myAge = json.getInt("age");
            Toast.makeText(this, "Your name is: " + myName + "(" + myAge + ")", Toast.LENGTH_SHORT).show();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        */

        /*
        // get data from Json array:
        try {
            JSONArray jsonArray = new JSONArray(arr);
            for (int i = 0; i < jsonArray.length(); i++){
                JSONObject object = jsonArray.getJSONObject(i);
                String name = object.getString("name");
                Toast.makeText(this, "Welcome: " + name, Toast.LENGTH_SHORT).show();
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        */

        // get data from complex:
        try {
            JSONObject object = new JSONObject(complex);
            JSONArray arr = object.getJSONArray("students");
            for (int i = 0; i < arr.length(); i++){
                JSONObject jsonObject = arr.getJSONObject(i);
                Toast.makeText(this, jsonObject.getString("name"), Toast.LENGTH_SHORT).show();
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }
}
