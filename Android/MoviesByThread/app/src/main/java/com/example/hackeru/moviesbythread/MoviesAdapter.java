package com.example.hackeru.moviesbythread;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

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
        ImageView posterImageView;
        TextView titleTextView;
        TextView yearTextView;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView == null){
            viewHolder = new ViewHolder();
            convertView = LayoutInflater.from(context).inflate(R.layout.list_item, null); // parent is ViewGroup
            viewHolder.posterImageView = (ImageView) convertView.findViewById(R.id.list_item_image_view);
            viewHolder.titleTextView = (TextView) convertView.findViewById(R.id.list_item_title_text_view);
            viewHolder.yearTextView = (TextView) convertView.findViewById(R.id.list_item_year_text_view);
            convertView.setTag(viewHolder);
        }else{  // recycled!!!
            viewHolder = (ViewHolder) convertView.getTag();
        }
        // insert new data...

        if (position == 0){
            Log.d("Maayan", "started!!!");
        }
        //new ImageDownloadThread(movies.get(position).getPoster(), viewHolder.posterImageView).start();
        //new DownloadImageTask(viewHolder.posterImageView).execute(movies.get(position).getPoster());
        Picasso.with(context).load(movies.get(position).getPoster()).into(viewHolder.posterImageView);
        viewHolder.titleTextView.setText(movies.get(position).getTitle());
        viewHolder.yearTextView.setText(movies.get(position).getYear());
        return convertView;
    }

    private class DownloadImageTask extends AsyncTask<String, Void, Bitmap> {

        private ImageView imageView;

        public DownloadImageTask(ImageView imageView){
            this.imageView = imageView;
        }

        @Override
        protected Bitmap doInBackground(String... params) {
            try {
                URL url = new URL(params[0]);
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                InputStream in = connection.getInputStream();
                Bitmap bitmap = BitmapFactory.decodeStream(in);
                return bitmap;
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(Bitmap bitmap) {
            if (bitmap != null){
                imageView.setImageBitmap(bitmap);
                Log.d("Maayan", "finished!!!");
            }
        }
    }
}
