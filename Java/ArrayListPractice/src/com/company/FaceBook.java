package com.company;

import java.util.ArrayList;

/**
 * Created by hackeru on 5/30/2016.
 */
public class FaceBook {

    private ArrayList<User> users;
    private ArrayList<Message> messages;

    public FaceBook(){
        users = new ArrayList<>();
        messages = new ArrayList<>();
    }

    public void addUser(String name, String password){
        users.add(new User(name, password));
    }

    public int userCount(){
        return users.size();
    }

    public User getUser(String nameToFind){
        for (int i = 0; i < users.size(); i++){
            if (users.get(i).getName() == nameToFind){
                return users.get(i);
            }
        }
        return null;
    }

    public void sendMessage(User from, User to, String body){
        if (from != null && to != null && body != null && !body.isEmpty()){
            messages.add(new Message(from, to, body));
        }
    }

    public void getMyMessages(String name){
        for (int i = 0; i < messages.size(); i++){
            if (messages.get(i).getTo().getName() == name){
                System.out.println(messages.get(i).getBody());
            }
        }
    }

}
