package com.example.hackeru.whatsapp;

import android.util.Log;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

/**
 * Created by hackeru on 9/8/2016.
 */
public class SendMessageThread extends BaseThread {

    private String message;
    private int to, from;

    public SendMessageThread(String message, int to, int from){
        this.message = message;
        this.to = to;
        this.from = from;
    }

    @Override
    public void run() {
        OutputStream out = null;
        try {
            Socket socket = new Socket(SERVER_IP, SERVER_PORT);
            out = socket.getOutputStream();
            out.write(ACTION_SEND_MESSAGE);
            out.write(from);
            out.write(to);
            out.write(message.getBytes());
            Log.d("TAG", "send message to server DONE!");
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
        }
    }
}
