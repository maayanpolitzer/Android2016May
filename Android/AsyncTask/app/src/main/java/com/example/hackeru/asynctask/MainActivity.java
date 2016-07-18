package com.example.hackeru.asynctask;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageView imageview;
    private Button btn;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageview = (ImageView) findViewById(R.id.imageView);
        btn = (Button) findViewById(R.id.btn);
        progressBar = (ProgressBar) findViewById(R.id.progressBar);

        btn.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        String link = "http://www.nafis.co.il/filestock/img/img_1371723238-2.jpg";
        new DownloadTask().execute(link);
    }

    public class DownloadTask extends AsyncTask<String, Integer, Bitmap> {

        @Override
        protected void onPreExecute() { // MainThread
            progressBar.setVisibility(View.VISIBLE);
        }

        @Override
        protected Bitmap doInBackground(String... params) { // new Thread
            try {
                URL url = new URL(params[0]);
                HttpURLConnection con = (HttpURLConnection) url.openConnection();
                InputStream in = con.getInputStream();
                Bitmap bitmap = BitmapFactory.decodeStream(in);
                for (int i = 0; i < 100; i++){
                    Thread.sleep(40);
                    publishProgress(i); // calling the onProgressUpdate method.
                }
                return bitmap;
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onProgressUpdate(Integer... values) {    // MainThread.
            btn.setText(values[0] + "");
        }

        @Override
        protected void onPostExecute(Bitmap bitmap) {   // MainThread
            if (bitmap != null){
                imageview.setImageBitmap(bitmap);
                progressBar.setVisibility(View.INVISIBLE);
            }
        }
    }

}
