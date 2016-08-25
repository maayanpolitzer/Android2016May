package com.example.hackeru.callrecordingapp.infrastructure;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by hackeru on 8/25/2016.
 */
public class RecordingTableConnector {

    private SQLiteDatabase db;

    public RecordingTableConnector(Context context){
        DBOpenHelper helper = new DBOpenHelper(context);    // create the database  if doesn't exists.
        db = helper.getWritableDatabase();
    }

    public long insert(Call call){
        ContentValues values = new ContentValues(); // can be done also in Call class.
        values.put(DBOpenHelper.COLUMN_START, call.getStart());
        values.put(DBOpenHelper.COLUMN_END, call.getEnd());
        values.put(DBOpenHelper.COLUMN_PHONE_NUMBER, call.getPhoneNumber());
        values.put(DBOpenHelper.COLUMN_INCOMING, call.getIncoming());
        values.put(DBOpenHelper.COLUMN_FILE_URI, call.getFileUri());
        return db.insert(DBOpenHelper.RECORDINGS_TABLE_NAME, null, values);
    }

    public Cursor getAllData(){
        return db.query(DBOpenHelper.RECORDINGS_TABLE_NAME,
                null,
                null,
                null,
                null,
                null,
                DBOpenHelper.COLUMN_ID + " DESC");
    }

}
