package com.company;

/**
 * Created by hackeru on 6/9/2016.
 */
public class MyThread extends Thread {

    private int i;
    private volatile boolean running;

    public MyThread(int i){
        this.i = i;
        running = true;
    }

    @Override
    public void run() {
        while(running){
            System.out.println(i);
        }
        /*
        while(true){
            System.out.println(i);
        }
         */
    }


    public void shutDown() {
        running = false;
    }
}
