package com.example.hackeru.whatsapp;

import android.os.Handler;
import android.util.Log;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.ArrayList;

/**
 * Created by hackeru on 9/12/2016.
 */
public class GetUsersThread extends BaseThread {

    private OnUsersArrived listener;
    private Handler handler;

    public GetUsersThread(OnUsersArrived listener){
        this.listener = listener;
        handler = new Handler();
    }

    @Override
    public void run() {
        OutputStream out = null;
        InputStream in = null;
        try {
            Socket socket = new Socket(SERVER_IP, SERVER_PORT);
            out = socket.getOutputStream();
            in = socket.getInputStream();
            out.write(ACTION_GET_USERS);
            final StringBuilder sb = new StringBuilder();
            byte[] buffer = new byte[1024];
            int length;
            while((length = in.read(buffer)) > 0){
                sb.append(new String(buffer, 0, length));
            }
            handler.post(new Runnable() {
                @Override
                public void run() {
                    Log.d("TAG", "users:"  + sb.toString());
                    listener.displayUsers(sb.toString().split("/"));
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (out != null){
                try {
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (in != null){
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
