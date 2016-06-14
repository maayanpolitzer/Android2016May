package com.company;

import javafx.stage.Stage;

/**
 * Created by hackeru on 6/13/2016.
 */
public class MyThread extends Thread {

    private DelayListener listener;
    private volatile boolean running;   // running = false;

    public MyThread(DelayListener listener){
        this.listener = listener;
    }

    @Override
    public void run() {
        running = true;
        while (running){
            listener.changeText();
            try {
                sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public boolean isRunning(){
        return running;
    }

    public void shutDown(){
        running = false;
    }


}
