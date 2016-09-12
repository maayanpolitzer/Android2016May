package com.company;

/**
 * Created by hackeru on 9/8/2016.
 */
public class Message {

    private int from, to;
    private String body;
    private boolean read;

    public Message(int from, int to, String body){
        this.from = from;
        this.to = to;
        this.body = body;
        //read = false;
    }

    @Override
    public String toString() {
        return "From: " + from + ", To: " + to + ", Body: " + body;
    }

    public int getFrom() {
        return from;
    }

    public String getBody() {
        return body;
    }

    public void setRead(boolean read) {
        this.read = read;
    }

    public boolean isRead() {
        return read;
    }

    public int getTo() {
        return to;
    }
}
