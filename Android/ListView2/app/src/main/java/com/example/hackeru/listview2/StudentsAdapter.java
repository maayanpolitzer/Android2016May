package com.example.hackeru.listview2;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.provider.ContactsContract;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by hackeru on 7/7/2016.
 */
public class StudentsAdapter extends ArrayAdapter {

    private Student[] students;
    private Context context;

    public StudentsAdapter(Context context, Student[] students){
        super(context, R.layout.list_item, students);
        this.context = context;
        this.students = students;
    }

    private class ViewHolder {
        TextView nameTextView;
        TextView ageTextView;
        ImageView callImageView;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = null;
        if (convertView == null) {
            viewHolder = new ViewHolder();
            // Log.d("Maayan", "convertView: " + convertView);
            convertView = LayoutInflater.from(context).inflate(R.layout.list_item, null);
            viewHolder.nameTextView = (TextView) convertView.findViewById(R.id.list_item_name_text_view);
            viewHolder.ageTextView = (TextView) convertView.findViewById(R.id.list_item_age_text_view);
            viewHolder.callImageView = (ImageView) convertView.findViewById(R.id.list_item_call_image_view);
            viewHolder.callImageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + students[position].getPhoneNumber()));
                    context.startActivity(intent);
                }
            });
            convertView.setTag(viewHolder);
        }else{
            viewHolder = (ViewHolder) convertView.getTag();
        }
        viewHolder.nameTextView.setText(students[position].getName());
        viewHolder.ageTextView.setText("Age: " + students[position].getAge());
        return convertView;
    }
}
