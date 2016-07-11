package com.example.hackeru.broadcastreceiverglobal;

/**
 * Created by hackeru on 7/11/2016.
 */
public class Website {

    private String name;
    private String address;

    public Website(String name, String address){
        this.name = name;
        this.address = address;
    }

    public String getAddress() {
        return address;
    }

    @Override
    public String toString() {
        return name;
    }
}
