package com.company;

/**
 * Created by hackeru on 5/30/2016.
 */
public class Message {

    private User from;
    private User to;
    private String body;

    public Message(User from, User to, String body){
        this.from = from;
        this.to = to;
        this.body = body;
    }

    public User getFrom() {
        return from;
    }

    public User getTo() {
        return to;
    }

    public String getBody() {
        return body;
    }
}
