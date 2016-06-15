package com.company;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Main {

    private static final int PORT = 14999;
    private static ArrayList<String> messagesList;

    public static void main(String[] args) {
        messagesList = new ArrayList<>();
        try {
            ServerSocket server = new ServerSocket(PORT);
            Socket socket = null;
            while (true){
                System.out.println("waiting for clients...");
                socket = server.accept();
                System.out.println("client connected!!!");
                ClientThread thread = new ClientThread(socket, messagesList);
                thread.start();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static synchronized void addMessageToList(String message){
        messagesList.add(message);
    }
}
