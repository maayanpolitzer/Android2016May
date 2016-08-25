package com.example.hackeru.callrecordingapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.example.hackeru.callrecordingapp.infrastructure.RecordingTableConnector;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listView = (ListView) findViewById(R.id.activity_main_list_view);
        RecordingTableConnector connector = new RecordingTableConnector(this);
        CallsAdapter adapter = new CallsAdapter(this, connector.getAllData());
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this, "position: " + position + ", id: " + id, Toast.LENGTH_SHORT).show();
                /*
                Intent intent = new Intent(MainActivity.this, CallDetailActivity.class);
                intent.putExtra(CallDetailActivity.SONG, R.raw.song);
                startActivity(intent);
                */
            }
        });

    }
}
