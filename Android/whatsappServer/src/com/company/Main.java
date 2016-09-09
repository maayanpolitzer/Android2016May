package com.company;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Main {

    private static final int PORT = 10568;

    private static ArrayList<User> usersList = new ArrayList<>();
    private static ArrayList<Message> messagesList = new ArrayList<>();

    public static void main(String[] args) {

        try {
            ServerSocket server = new ServerSocket(PORT);  // start the server.
            while(true){
                System.out.println("waiting for clients...");
                Socket clientSocket = server.accept();  // client connected to the server
                System.out.println("client connected!");
                new ClientThread(clientSocket).start(); // new thread for each client.
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void addMessage(Message message){
        System.out.println(message);
        messagesList.add(message);
    }

    public static void addUser(User user){
        System.out.println(user);
        usersList.add(user);
    }

}
