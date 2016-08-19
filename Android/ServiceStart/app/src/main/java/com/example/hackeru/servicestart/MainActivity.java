package com.example.hackeru.servicestart;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class MainActivity extends AppCompatActivity {

    private String link = "http://madame.lefigaro.fr/sites/default/files/imagecache/photo_verticale_grande/2011/12/460282798.jpg";
    public static final String URL = "url";
    public static final String FILE_NAME = "myImage2.jpg";
    private BroadcastReceiver receiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            displayImage(null);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    @Override
    protected void onResume() {
        super.onResume();
        IntentFilter filter = new IntentFilter("99fm");
        registerReceiver(receiver, filter);
    }

    @Override
    protected void onPause() {
        super.onPause();
        unregisterReceiver(receiver);
    }

    public void startService(View view) {
        Intent intent = new Intent(this, DownloadService.class);
        intent.putExtra(URL, link);
        startService(intent);
    }

    public void displayImage(View view) {
        ImageView imageView = (ImageView) findViewById(R.id.imageView);
        /*
        File file = new File(getFilesDir(), FILE_NAME);
        imageView.setImageURI(Uri.fromFile(file));
        */
        try {
            FileInputStream in = openFileInput("myImage.jpg");
            Bitmap bitmap = BitmapFactory.decodeStream(in);
            imageView.setImageBitmap(bitmap);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }
}
