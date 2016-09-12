package com.company;

/**
 * Created by hackeru on 9/8/2016.
 */
public class User {

    private String name, email, password;
    private int id;
    private static int counter = 0;

    public User(String email, String name, String password){
        this.email = email;
        this.name = name;
        this.password = password;
        id = counter++;
    }

    @Override
    public String toString() {
        return "id: " + id + ", name: " + name + ", email: " + email + ", password: " + password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getId() {
        return id;
    }
}
