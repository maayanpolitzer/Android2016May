package com.example.hackeru.whatsapp;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * Created by hackeru on 9/8/2016.
 */
public class RegisterThread extends BaseThread {

    private String email, name, password;
    private OnRegisterCompleted listener;

    public RegisterThread(OnRegisterCompleted listener, String email, String name, String password){
        this.listener = listener;
        this.email = email + "/";
        this.name = name + "/";
        this.password = password;
    }

    @Override
    public void run() {
        OutputStream out = null;
        InputStream in = null;  // to get the user id from server.
        try {
            Socket socket = new Socket(SERVER_IP, SERVER_PORT);
            out = socket.getOutputStream();
            in = socket.getInputStream();
            out.write(ACTION_REGISTER);
            out.write((email + name + password).getBytes());
            out.flush();
            int userId = in.read();
            if (userId != -1){
                listener.login(userId);
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
