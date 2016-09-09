package com.company;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * Created by hackeru on 9/8/2016.
 */
public class ClientThread extends Thread {

    private static final int ACTION_SEND_MESSAGE = 1;
    private static final int ACTION_SEND_IMAGE = 2;
    private static final int ACTION_REGISTER = 3;
    private static final int ACTION_LOGIN = 4;
    private static final int ACTION_GET_MESSAGE = 5;

    private Socket socket;

    public ClientThread(Socket socket){
        this.socket = socket;
    }

    @Override
    public void run() {
        OutputStream out = null;
        InputStream in = null;
        try {
            in = socket.getInputStream();
            out = socket.getOutputStream();
            int action = in.read();
            switch(action){
                case ACTION_REGISTER:
                    System.out.println("REGISTER");
                    byte[] buffer = new byte[1024];
                    int bufferLength;
                    bufferLength = in.read(buffer);
                    String data = new String(buffer, 0, bufferLength);
                    System.out.println(data);
                    String[] arr = data.split("/");
                    User user = new User(arr[0], arr[1], arr[2]);
                    Main.addUser(user);
                    out.write(user.getId());
                    break;
                case ACTION_SEND_MESSAGE:
                    System.out.println("SEND_MESSAGE");
                    byte[] bytes = new byte[1024];  // the container of chars to get.
                    /*
                    int length = in.read(bytes);    // how many char was read.
                    String message = new String(bytes, 0, length);  // create a new String
                    */
                    int length = 0;
                    StringBuilder sb = new StringBuilder();
                    while((length = in.read(bytes)) > 0){
                        sb.append(new String(bytes, 0, length));
                    }
                    System.out.println("Message: " + sb.toString());
                    break;
                case ACTION_SEND_IMAGE:
                    System.out.println("SEND IMAGE");
                    break;
            }
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
