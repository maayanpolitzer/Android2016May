package com.example.hackeru.customlistview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    Monster[] monsters = {
            new Monster(R.drawable.four, "Maayan1", "052-5555555"),
            new Monster(R.drawable.one, "Maayan2", "052-3333333"),
            new Monster(R.drawable.two, "Maayan3", "052-44444444"),
            new Monster(R.drawable.four, "Maayan1", "052-5555555"),
            new Monster(R.drawable.one, "Maayan2", "052-3333333"),
            new Monster(R.drawable.two, "Maayan3", "052-44444444"),
            new Monster(R.drawable.four, "Maayan1", "052-5555555"),
            new Monster(R.drawable.one, "Maayan2", "052-3333333"),
            new Monster(R.drawable.two, "Maayan3", "052-44444444"),
            new Monster(R.drawable.four, "Maayan1", "052-5555555"),
            new Monster(R.drawable.one, "Maayan2", "052-3333333"),
            new Monster(R.drawable.two, "Maayan3", "052-44444444"),
            new Monster(R.drawable.four, "Maayan1", "052-5555555"),
            new Monster(R.drawable.one, "Maayan2", "052-3333333"),
            new Monster(R.drawable.two, "Maayan3", "052-44444444"),
            new Monster(R.drawable.four, "Maayan1", "052-5555555"),
            new Monster(R.drawable.one, "Maayan2", "052-3333333"),
            new Monster(R.drawable.two, "Maayan3", "052-44444444"),
            new Monster(R.drawable.four, "Maayan1", "052-5555555"),
            new Monster(R.drawable.one, "Maayan2", "052-3333333"),
            new Monster(R.drawable.two, "Maayan3", "052-44444444"),
            new Monster(R.drawable.four, "Maayan1", "052-5555555"),
            new Monster(R.drawable.one, "Maayan2", "052-3333333"),
            new Monster(R.drawable.two, "Maayan3", "052-44444444"),
            new Monster(R.drawable.three, "Maayan4", "052-11111111")
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listView = (ListView) findViewById(R.id.listView);
        MonsterAdapter adapter = new MonsterAdapter(this, monsters);
        listView.setAdapter(adapter);

    }
}
