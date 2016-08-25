package com.example.hackeru.callrecordingapp;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.hackeru.callrecordingapp.infrastructure.DBOpenHelper;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by hackeru on 8/25/2016.
 */
public class CallsAdapter extends CursorAdapter {

    private SimpleDateFormat dateFormat = new SimpleDateFormat("hh:mm:ss dd/MM");

    public CallsAdapter(Context context, Cursor cursor){
        super(context, cursor, 0);
        //super(context, cursor, FLAG_AUTO_REQUERY);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        View view = LayoutInflater.from(context).inflate(R.layout.list_item, parent, false);    // true will return the parent(listView), false will return the inflated view(list_item).
        return view;
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        ImageView callImageView = (ImageView) view.findViewById(R.id.list_item_call_image_view);
        TextView phoneNumberTextView = (TextView) view.findViewById(R.id.list_item_phone_number_text_view);
        TextView callDateTextView = (TextView) view.findViewById(R.id.list_item_call_date_text_view);
        TextView callDurationTextView = (TextView) view.findViewById(R.id.list_item_call_duration_text_view);

        int incomingCall = cursor.getInt(cursor.getColumnIndex(DBOpenHelper.COLUMN_INCOMING));
        long start = cursor.getLong(cursor.getColumnIndex(DBOpenHelper.COLUMN_START));
        long end = cursor.getLong(cursor.getColumnIndex(DBOpenHelper.COLUMN_END));



        callImageView.setImageResource(incomingCall == 1 ? android.R.drawable.sym_call_incoming : android.R.drawable.sym_call_outgoing);
        phoneNumberTextView.setText(cursor.getString(cursor.getColumnIndex(DBOpenHelper.COLUMN_PHONE_NUMBER)));
        callDateTextView.setText(dateFormat.format(new Date(start)));
        callDurationTextView.setText(CallDetailActivity.convertMilliToString((end-start)));



        /*
        if (incomingCall == 1){
            callImageView.setImageResource(android.R.drawable.sym_call_incoming);
        }else{
            callImageView.setImageResource(android.R.drawable.sym_call_outgoing);
        }
        */
    }


}
