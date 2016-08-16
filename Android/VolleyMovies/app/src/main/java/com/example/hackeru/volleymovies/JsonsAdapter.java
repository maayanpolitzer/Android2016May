package com.example.hackeru.volleymovies;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by hackeru on 8/15/2016.
 */
public class JsonsAdapter extends BaseAdapter {

    private Context context;
    private JSONArray arr;

    public JsonsAdapter(Context context, JSONArray arr){
        this.context = context;
        this.arr = arr;
    }

    @Override
    public int getCount() {
        return arr.length();
    }

    @Override
    public Object getItem(int position) {
        try {
            return arr.get(position);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    private class ViewHolder {
        TextView titleTextView;
        ImageView posterImageView;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = null;
        if (convertView == null){
            convertView = LayoutInflater.from(context).inflate(R.layout.list_item, parent, false);  // to get the list_item view that was inflated, write false.
            viewHolder = new ViewHolder();
            viewHolder.titleTextView = (TextView) convertView.findViewById(R.id.list_item_text_view);
            viewHolder.posterImageView = (ImageView) convertView.findViewById(R.id.list_item_image_view);
            convertView.setTag(viewHolder);
        }else{
            viewHolder = (ViewHolder) convertView.getTag();
        }
        try {
            viewHolder.titleTextView.setText(arr.getJSONObject(position).getString("Title"));
            Picasso.with(context).load(arr.getJSONObject(position).getString("Poster")).into(viewHolder.posterImageView);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return convertView;
    }
}
