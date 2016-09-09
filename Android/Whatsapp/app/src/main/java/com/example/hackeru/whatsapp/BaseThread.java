package com.example.hackeru.whatsapp;

/**
 * Created by hackeru on 9/8/2016.
 */
public class BaseThread extends Thread {
    protected static final String SERVER_IP = "10.0.7.49";
    protected static final int SERVER_PORT = 10568;
    protected static final int ACTION_SEND_MESSAGE = 1;
    protected static final int ACTION_SEND_IMAGE = 2;
    protected static final int ACTION_REGISTER = 3;
    protected static final int ACTION_LOGIN = 4;
    protected static final int ACTION_GET_MESSAGE = 5;
}
