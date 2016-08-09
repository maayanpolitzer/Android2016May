package com.example.hackeru.sqlitewithimagesaving;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by hackeru on 8/8/2016.
 */
public class ContactsAdapter extends CursorAdapter {

    public ContactsAdapter(Context context, Cursor cursor){
        super(context, cursor, 0);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        View view = LayoutInflater.from(context).inflate(R.layout.list_item, parent, false);
        return view;
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        TextView nameTextView = (TextView) view.findViewById(R.id.list_item_name_text_view);
        ImageView avatarImageView = (ImageView) view.findViewById(R.id.list_item_avatar_image_view);
        String name = cursor.getString(cursor.getColumnIndex(DBOpenHelper.COLUMN_NAME));
        String avatar = cursor.getString(cursor.getColumnIndex(DBOpenHelper.COLUMN_IMAGE_URI));
        nameTextView.setText(name);
        avatarImageView.setImageURI(Uri.parse(avatar));
    }

}
