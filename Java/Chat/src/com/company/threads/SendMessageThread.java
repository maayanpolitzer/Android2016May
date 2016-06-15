package com.company.threads;

import com.company.Main;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * Created by hackeru on 6/15/2016.
 */
public class SendMessageThread extends Thread {

    private String message;

    public SendMessageThread(String message){
        this.message = message;
    }

    @Override
    public void run() {
        OutputStream out = null;
        InputStream in = null;
        try {
            Socket socket = new Socket(Main.IP_ADDRESS, Main.PORT);
            out = socket.getOutputStream();
            in = socket.getInputStream();
            out.write(1);
            //out.write(message.getBytes());
            byte[] bytes = message.getBytes();
            out.write(bytes);   // send message to server
            int ok = in.read();
            if (ok == 200){
                //System.out.println("Message sent successfully!!!! ( " + message + " )");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
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
