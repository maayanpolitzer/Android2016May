package com.company;

public class Main {

    public int counter = 0;

    public static void main(String[] args) {
        MyThread m = new MyThread(678);
        m.start();
        try {
            Thread.sleep(3500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        m.shutDown();
        /*
        Main m = new Main();
        m.work();
        */
    }
/*
    public void work(){
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10000; i++){
                    increment();
                }
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10000; i++){
                    increment();
                }
            }
        });
        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Counter is: " + counter);
    }

    public synchronized void increment(){
        counter++;
    }
    */
}
