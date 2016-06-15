package com.company;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by hackeru on 6/15/2016.
 */
public class ClientThread extends Thread {

    private Socket socket;
    private ArrayList<String> messagesList;

    public ClientThread(Socket socket, ArrayList<String> messagesList){
        this.socket = socket;
        this.messagesList = messagesList;
    }

    @Override
    public void run() {
        InputStream in = null;
        OutputStream out = null;
        try {
            in = socket.getInputStream();
            out = socket.getOutputStream();
            int action = in.read();
            switch (action){
                case 1:
                    // client send message...
                    byte[] bytes = new byte[1024];
                    int length = in.read(bytes);
                    // convert byte[] to String...
                    String message = new String(bytes, 0, length);
                    System.out.println(message);
                    Main.addMessageToList(message);
                    out.write(200);
                    break;
                case 2:
                    // client wants to get messages...
                    int messageInClient = in.read();
                    int messagesToSendToClient = messagesList.size() - messageInClient;
                    out.write(messagesToSendToClient);
                    System.out.println("c: " + messageInClient + ", send: " + messagesToSendToClient + ", list size: " + messagesList.size());
                    for (int i = messageInClient; i < messagesList.size(); i++){
                        byte[] messageInBytes = messagesList.get(i).getBytes();
                        out.write(messageInBytes);
                    }
                    break;
            }
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
}
