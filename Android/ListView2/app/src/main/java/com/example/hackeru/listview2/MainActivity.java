package com.example.hackeru.listview2;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private Student[] students = {
            new Student("Maayan", 30),
            new Student("Liran", 21),
            new Student("Lilach", 39),
            new Student("Asher", 54),
            new Student("Maayan", 30),
            new Student("Liran", 21),
            new Student("Lilach", 39),
            new Student("Asher", 54),
            new Student("Maayan", 30),
            new Student("Liran", 21),
            new Student("Lilach", 39),
            new Student("Asher", 54),
            new Student("Maayan", 30),
            new Student("Liran", 21),
            new Student("Lilach", 39),
            new Student("Asher", 54),
            new Student("Maayan", 30),
            new Student("Liran", 21),
            new Student("Lilach", 39),
            new Student("Asher", 54),
            new Student("Moran", 22)
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listView = (ListView) findViewById(R.id.list);
        StudentsAdapter adapter = new StudentsAdapter(this, students);
        listView.setAdapter(adapter);
        //listView.setOnItemClickListener(this);
    }
/*
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Uri phoneNumber = Uri.parse("tel:" + students[position].getPhoneNumber());
        Intent intent = new Intent(Intent.ACTION_DIAL, phoneNumber);
        startActivity(intent);
    }
    */
}
