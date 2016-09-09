package com.example.hackeru.whatsapp.db;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by hackeru on 9/8/2016.
 */
public class DBOpenHelper extends SQLiteOpenHelper {

    private static final String DB_NAME = "myDB.db";
    private static final int DB_VERSION = 1;

    public static final String TABLE_MESSAGES = "messages";
    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_FROM = "from";
    public static final String COLUMN_TO = "to";
    public static final String COLUMN_BODY = "body";
    public static final String COLUMN_READ = "read";
    public static final String COLUMN_TIME = "time";

    private static final String CREATE_TABLE_MESSAGES = "CREATE TABLE " + TABLE_MESSAGES + " (" +
            COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            COLUMN_FROM + " TEXT, " +
            COLUMN_TO + " TEXT, " +
            COLUMN_BODY + " TEXT, " +
            COLUMN_READ + " INTEGER, " +
            COLUMN_TIME + " INTEGER);";

    public DBOpenHelper(Context context){
        super(context, DB_NAME, null, DB_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_MESSAGES);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
