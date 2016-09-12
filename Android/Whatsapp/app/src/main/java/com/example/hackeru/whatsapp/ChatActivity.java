package com.example.hackeru.whatsapp;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.NotificationCompat;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import com.example.hackeru.whatsapp.db.DBOpenHelper;

public class ChatActivity extends BaseAuthenticatedActivity implements View.OnClickListener {

    private LinearLayout messagesLayout;
    private EditText messageEditText;
    private ImageView sendMessageImageView;
    private int chatterID;
    private Handler handler;
    private ScrollView scrollView;

    @Override
    public void messageArrived(int from, final String message) {
        if (from != chatterID){
            sendNotification(from, message);
        }else {
            handler.post(new Runnable() {
                @Override
                public void run() {
                    displayMessages(message, true);
                }
            });

        }
    }

    @Override
    protected void onLoggedIn(Bundle savedInstanceState) {
        setContentView(R.layout.activity_chat);

        messagesLayout = (LinearLayout) findViewById(R.id.messages_layout);
        messageEditText = (EditText) findViewById(R.id.input_message_edit_text);
        sendMessageImageView = (ImageView) findViewById(R.id.input_message_send_btn);
        scrollView = (ScrollView) findViewById(R.id.scrollView) ;

        handler = new Handler();

        String chatter = getIntent().getStringExtra(CHATTER);
        chatterID = getIntent().getIntExtra(CHATTER_ID, -1);

        getSupportActionBar().setTitle("Chat with " + chatter); // change the action bar title.

        sendMessageImageView.setOnClickListener(this);

        DBOpenHelper helper = new DBOpenHelper(this);
        SQLiteDatabase db = helper.getReadableDatabase();
        Cursor cursor = db.query(DBOpenHelper.TABLE_MESSAGES,
                null,
                "(" + DBOpenHelper.COLUMN_FROM + "=? AND " + DBOpenHelper.COLUMN_TO + "=?) OR (" + DBOpenHelper.COLUMN_FROM + "=? AND " + DBOpenHelper.COLUMN_TO + "=?)",
                new String[]{chatterID + "", settings.getInt(USER_ID, -1) + "", settings.getInt(USER_ID, -1) + "", chatterID + ""},
                null,
                null,
                null);
        if (cursor.getCount() > 0){
            cursor.moveToFirst();
            do{
                int from = cursor.getInt(cursor.getColumnIndex(DBOpenHelper.COLUMN_FROM));
                String message = cursor.getString(cursor.getColumnIndex(DBOpenHelper.COLUMN_BODY));
                displayMessages(message, from == chatterID);
            }while (cursor.moveToNext());
        }
    }

    @Override
    public void onClick(View v) {
        String message = messageEditText.getText().toString().trim();
        if (!message.isEmpty()){
            new SendMessageThread(message, chatterID, settings.getInt(USER_ID, -1)).start();
            saveMessageToDB(message, chatterID);
            displayMessages(message, false);
        }
    }

    private void saveMessageToDB(String message, int chatterID){
        DBOpenHelper helper = new DBOpenHelper(this);
        SQLiteDatabase db = helper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(DBOpenHelper.COLUMN_FROM, settings.getInt(USER_ID, -1));
        values.put(DBOpenHelper.COLUMN_TO, chatterID);
        values.put(DBOpenHelper.COLUMN_BODY, message);
        db.insert(DBOpenHelper.TABLE_MESSAGES, null, values);
    }



    private void displayMessages(String message, boolean incoming) {
        View view = getLayoutInflater().inflate(incoming ? R.layout.message_in : R.layout.message_out, null);
        TextView textView = (TextView) view.findViewById(R.id.message_body);
        textView.setText(message);
        messagesLayout.addView(view);
        scrollView.scrollTo(0, scrollView.getBottom());

    }
}
