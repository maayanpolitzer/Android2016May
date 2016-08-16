package com.example.hackeru.volleymovies;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageRequest;
import com.android.volley.toolbox.Volley;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by hackeru on 8/15/2016.
 */
public class MoviesAdapter extends ArrayAdapter<Movie> {

    private Context context;
    private ArrayList<Movie> movies;
    private RequestQueue queue;

    public MoviesAdapter(Context context, ArrayList<Movie> movies){
        super(context, R.layout.list_item, movies);
        this.context = context;
        this.movies = movies;
        queue = Volley.newRequestQueue(context);
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
        viewHolder.titleTextView.setText(movies.get(position).getTitle());
        //Picasso.with(context).load(movies.get(position).getPoster()).into(viewHolder.posterImageView);
        getImage(movies.get(position).getPoster(), viewHolder.posterImageView);
        return convertView;
    }

    private void getImage(String str,final ImageView imageView){
        ImageRequest request = new ImageRequest(
                str,
                new Response.Listener<Bitmap>() {
                    @Override
                    public void onResponse(Bitmap response) {
                        imageView.setImageBitmap(response);
                    }
                },
                0,
                0,
                null,
                null,
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        imageView.setImageResource(R.mipmap.ic_launcher);
                    }
                }
        );
        queue.add(request);

    }

}
















