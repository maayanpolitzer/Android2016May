package com.example.hackeru.whatsapp;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

/**
 * Created by hackeru on 9/8/2016.
 */
public class SendMessageThread extends BaseThread {


    private String message;

    public SendMessageThread(String message){
        this.message = message;

    }

    @Override
    public void run() {
        OutputStream out = null;
        try {
            Socket socket = new Socket(SERVER_IP, SERVER_PORT);
            out = socket.getOutputStream();
            out.write(ACTION_SEND_MESSAGE);
            out.write(message.getBytes());
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
