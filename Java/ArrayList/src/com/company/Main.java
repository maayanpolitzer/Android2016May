package com.company;

import java.util.ArrayList;

public class Main {

static ArrayList<User> users;

    public static void main(String[] args) {

        users = new ArrayList<>();
        users.add(new User("maayan", "123"));
        users.add(new User("Itay", "abc"));

        String myUsername = "maayan";
        String myPassword = "123";

        if (checkUser(myUsername, myPassword)){
            System.out.println("GREAT!!!");
        }else{
            System.out.println("TRY AGAIN");
        }
    }

    private static boolean checkUser(String name, String pass){
        for (int i = 0; i < users.size(); i++){
            if (users.get(i).getUsername() == name && users.get(i).getPassword() == pass){
                return true;
            }
        }
        return false;
    }
}
