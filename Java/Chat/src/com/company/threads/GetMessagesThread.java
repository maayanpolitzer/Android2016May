package com.company.threads;

/**
 * Created by hackeru on 6/13/2016.
 */
public class GetMessagesThread extends Thread {

    private volatile boolean running;
    private int counter;

    public GetMessagesThread(int counter){
        this.counter = counter;
        running = true;
    }

    @Override
    public void run() {
        while(running){
            getMessages();
            try {
                sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void getMessages(){
        // next lesson...
        System.out.println("get messages() called");
    }

    public void shutDown(){
        running = false;
        System.out.println("Thread stopped!!!");
    }

}
