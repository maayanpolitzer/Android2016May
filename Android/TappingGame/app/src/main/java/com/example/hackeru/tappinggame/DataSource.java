package com.example.hackeru.tappinggame;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by hackeru on 04-08-16.
 */
public class DataSource {

    private SQLiteDatabase db;
    private DBOpenHelper helper;

    public DataSource(Context context){
        helper = new DBOpenHelper(context);
    }

    public void insertPlayer(String name, int score){
        ContentValues values = new ContentValues();
        values.put(DBOpenHelper.COLUMN_NAME, name);
        values.put(DBOpenHelper.COLUMN_SCORE, score);
        db.insert(DBOpenHelper.TABLE_SCORES, null, values);
    }

    public void open(){
        db = helper.getWritableDatabase();
    }

    public void close(){
        db.close();
    }

    public Cursor getAllData(){
        //return db.rawQuery("SELECT * FROM " + DBOpenHelper.TABLE_SCORES, null);
        return db.query(
                DBOpenHelper.TABLE_SCORES,
                null,
                null,
                null,
                null,
                null,
                DBOpenHelper.COLUMN_SCORE + " DESC"
        );
    }
    /*
    public Cursor getDataByName(){
        return db.query(
                DBOpenHelper.TABLE_SCORES,                                              // table name
                null,                                                                   // get all columns.
                DBOpenHelper.COLUMN_NAME + "=? OR " + DBOpenHelper.COLUMN_NAME + "=?",  // filter
                new String[]{"Maayan", "Itay"},                                         // filter questions marks.
                null,                                                                   //  order by groups
                null,                                                                   // display some of the groups.
                DBOpenHelper.COLUMN_SCORE + " DESC",                                    // order
                "5"                                                                     // limit
        );
    }
    */

    public Cursor getDataByName(String name){
        return db.query(
                DBOpenHelper.TABLE_SCORES,
                null,
                DBOpenHelper.COLUMN_NAME + "=?",
                new String[]{name},
                null,
                null,
                null
        );
    }

    public int delete(int id){
        int rowsAffected = db.delete(
                DBOpenHelper.TABLE_SCORES,
                DBOpenHelper.COLUMN_ID + "=?",
                new String[]{id + ""}
        );
        return rowsAffected;
    }

    public int update(String name, int newScore){
        ContentValues values = new ContentValues();
        values.put(DBOpenHelper.COLUMN_SCORE, newScore);
        int rowsAffected = db.update(
                DBOpenHelper.TABLE_SCORES,
                values,
                DBOpenHelper.COLUMN_NAME + "=?",
                new String[]{name}
        );
        return rowsAffected;
    }

    public void insertData(String name, int score){
        Cursor cursor = getDataByName(name);
        if(cursor.getCount() == 0){
            insertPlayer(name, score);
        }else{
            update(name, score);
        }
    }

}
