package com.example.hackeru.moviesbythread;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Handler;
import android.util.Log;
import android.widget.ImageView;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by hackeru on 7/18/2016.
 */
public class ImageDownloadThread extends Thread {

    private String link;
    private ImageView imageView;
    private Handler handler;

    public ImageDownloadThread(String link, ImageView imageView){
        this.link = link;
        this.imageView = imageView;
        handler = new Handler();
    }

    @Override
    public void run() {
        try {
            URL url = new URL(link);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            InputStream in = connection.getInputStream();
            final Bitmap bitmap = BitmapFactory.decodeStream(in);
            handler.post(new Runnable() {
                @Override
                public void run() {
                    imageView.setImageBitmap(bitmap);
                    Log.d("Maayan", "finished!");
                }
            });
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
