package com.company.threads;

import com.company.Main;
import com.company.interfaces.OnMessageArrived;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * Created by hackeru on 6/13/2016.
 */
public class GetMessagesThread extends Thread {

    private volatile boolean running;
    private int counter;
    private OnMessageArrived listener;

    public GetMessagesThread(OnMessageArrived listener) {
        running = true;
        this.listener = listener;
    }

    @Override
    public void run() {
        while (running) {
            getMessages();
            try {
                sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void getMessages() {
        // send numberOfMessages to server...
        InputStream in = null;
        OutputStream out = null;
        try {
            Socket socket = new Socket(Main.IP_ADDRESS, Main.PORT);
            in = socket.getInputStream();
            out = socket.getOutputStream();
            out.write(2);
            out.write(counter);
            int messagesToRead = in.read();
            System.out.println("i have : " + counter + ", need to read: " + messagesToRead);
            if (messagesToRead > 0) {
                for (int i = 0; i < messagesToRead; i++) {
                    byte[] bytes = new byte[1024];
                    int length = in.read(bytes);
                    if (length != -1) {
                        String message = new String(bytes, 0, length);
                        counter++;
                        System.out.println(message);
                        listener.addMessageToChatView(message);
                    }
                }
            } else {
                System.out.println("nothing to read...");
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (out != null) {
                try {
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    public void shutDown() {
        running = false;
        System.out.println("Thread stopped!!!");
    }

}
