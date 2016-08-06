package com.example.hackeru.tappinggame;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class WallOfFameActivity extends AppCompatActivity {

    private DataSource dbSource;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wall_of_fame);

        dbSource = new DataSource(this);

        dbSource.open();
        Cursor cursor = dbSource.getAllData();

        cursor.moveToFirst();
        do{
            int id = cursor.getInt(cursor.getColumnIndex("id"));
            String name = cursor.getString(cursor.getColumnIndex(DBOpenHelper.COLUMN_NAME));
            int score = cursor.getInt(cursor.getColumnIndex(DBOpenHelper.COLUMN_SCORE));
            Log.d("TAG", "id:" + id + ": " + name + " - " + score);
        }while (cursor.moveToNext());
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        dbSource.close();
    }
}
