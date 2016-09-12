package com.example.hackeru.whatsapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import android.widget.Toast;

import com.example.hackeru.whatsapp.db.DBOpenHelper;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * Created by hackeru on 9/12/2016.
 */
public class GetMessageThread extends BaseThread {

    private int userID;
    private boolean running;
    private SQLiteDatabase db;
    private Context context;

    public GetMessageThread(Context context, int userID){
        this.userID = userID;
        running = true;
        this.context = context;
        DBOpenHelper helper = new DBOpenHelper(context);
        db = helper.getWritableDatabase();
    }

    @Override
    public void run() {
        while (running){
            InputStream in = null;
            OutputStream out = null;
            try {
                Socket socket = new Socket(SERVER_IP, SERVER_PORT);
                in = socket.getInputStream();
                out = socket.getOutputStream();
                out.write(ACTION_GET_MESSAGE);
                out.write(userID);
                if (in.read() == 1) {
                    int from = in.read();
                    byte[] buffer = new byte[1024];
                    int length;
                    StringBuilder sb = new StringBuilder();
                    while ((length = in.read(buffer)) > 0) {
                        sb.append(new String(buffer, 0, length));
                    }
                    Log.d("TAG", "Message received: " + sb.toString());
                    saveMessageToDB(from, sb.toString());
                    ((BaseAuthenticatedActivity)context).messageArrived(from, sb.toString());
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (in != null){
                    try {
                        in.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                if (out != null){
                    try {
                        out.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
            try {
                sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void saveMessageToDB(int from, String message) {
        ContentValues values = new ContentValues();
        values.put(DBOpenHelper.COLUMN_FROM, from);
        values.put(DBOpenHelper.COLUMN_TO, userID);
        values.put(DBOpenHelper.COLUMN_BODY, message);
        db.insert(DBOpenHelper.TABLE_MESSAGES, null, values);
        Log.d("TAG", "Message from: " + from + ", body: " + message);
    }

    public void shutDown(){
        running = false;
    }
}
