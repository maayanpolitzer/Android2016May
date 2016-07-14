package com.example.hackeru.moviesbythread;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by hackeru on 7/14/2016.
 */
public class MoviesAdapter extends ArrayAdapter {

    private Context context;
    private ArrayList<Movie> movies;

    public MoviesAdapter(Context context, ArrayList<Movie> movies){
        super(context, R.layout.list_item, movies);
        this.context = context;
        this.movies = movies;
    }

    private class ViewHolder {
        ImageView poster;
        TextView title;
        TextView year;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;




        viewHolder.poster.setImageBitmap();
        return convertView;
    }
}
