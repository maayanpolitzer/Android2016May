package com.company;

/**
 * Created by hackeru on 6/9/2016.
 */
public class Liran extends Thread {

    @Override
    public void run() {
        for (int i = 0; i < 10; i++){
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Liran thread: " + i);
        }
    }
}
