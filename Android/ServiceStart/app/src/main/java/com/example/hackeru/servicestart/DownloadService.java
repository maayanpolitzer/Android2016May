package com.example.hackeru.servicestart;

import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by hackeru on 8/18/2016.
 */
public class DownloadService extends Service {

    // TODO: 8/18/2016 Don't forget declare the service in the MANIFEST file.

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        // method call automaticcaly when starting the service.
        final String link = intent.getStringExtra(MainActivity.URL);
        Toast.makeText(DownloadService.this, "Link: " + link, Toast.LENGTH_SHORT).show();
        new Thread(new Runnable() {
            @Override
            public void run() {
                InputStream in = null;
                FileOutputStream out = null;
                try {
                    URL url = new URL(link);
                    HttpURLConnection con = (HttpURLConnection) url.openConnection();
                    in = con.getInputStream();
                    File file = new File(getFilesDir(), MainActivity.FILE_NAME);
                    out = new FileOutputStream(file);
                    int length;
                    byte[] buffer = new byte[1024];
                    while ((length = in.read(buffer)) > 0){
                        out.write(buffer, 0, length);
                    }
                    //Log.d("TAG", "download DONE!");
                    Intent intent = new Intent("99fm");
                    sendBroadcast(intent);
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }finally {
                    if (in != null){
                        try {
                            in.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                    if (out != null){
                        try {
                            out.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }).start();
        return START_NOT_STICKY;
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
