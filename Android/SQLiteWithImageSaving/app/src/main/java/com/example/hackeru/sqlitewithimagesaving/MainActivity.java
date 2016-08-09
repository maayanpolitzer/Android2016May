package com.example.hackeru.sqlitewithimagesaving;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listView = (ListView) findViewById(R.id.listView);

        DBOpenHelper helper = new DBOpenHelper(this);
        SQLiteDatabase db = helper.getReadableDatabase();
        //Cursor cursor = db.rawQuery("SELECT * FROM " + DBOpenHelper.TABLE_CONTACTS, null);
        Cursor cursor = db.query(
                DBOpenHelper.TABLE_CONTACTS,
                null,
                null,
                null,
                null,
                null,
                null
        );
        ContactsAdapter adapter = new ContactsAdapter(this, cursor);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(this);
        db.close();

        findViewById(R.id.addContactBtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AddContactActivity.class);
                startActivity(intent);
            }
        });

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

    }
}
