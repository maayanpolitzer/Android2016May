package com.example.hackeru.callrecordingapp.infrastructure;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by hackeru on 8/18/2016.
 */
public class DBOpenHelper extends SQLiteOpenHelper {

    private static final String DB_NAME = "recordingDB.db";
    private static final int DB_VERSION = 1;

    public static final String RECORDINGS_TABLE_NAME = "recordingsTable";

    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_PHONE_NUMBER = "phoneNumber";
    public static final String COLUMN_INCOMING = "incoming";
    public static final String COLUMN_START = "start";
    public static final String COLUMN_END = "end";
    public static final String COLUMN_FILE_URI = "fileUri";

    private static final String CREATE_TABLE_RECORDINGS = "CREATE TABLE " + RECORDINGS_TABLE_NAME + " (" +
            COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            COLUMN_INCOMING + " INTEGER, " +
            COLUMN_PHONE_NUMBER + " TEXT, " +
            COLUMN_START + " INTEGER, " +
            COLUMN_END + " INTEGER, " +
            COLUMN_FILE_URI + " TEXT);";

    public DBOpenHelper(Context context){
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_RECORDINGS);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
