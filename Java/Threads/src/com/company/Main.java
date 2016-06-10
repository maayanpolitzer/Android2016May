package com.company;

public class Main {

    public static void main(String[] args) {
        /*
        // three ways to create a thread...
        1.create a class that extends Thread,
          override run() method,
          create object,
          call start() method.
        2. create a class that implements the Runnable interface,
         override run() method,
         create object from Runner class,
         create object from Thread class and pass the runner as parameter
         call start() method.
        */

        Thread t3 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++){
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("From anonymous " + i);
                }
            }
        });
        t3.start();

        Runner r = new Runner();
        Thread t = new Thread(r);
        t.start();

        Liran l = new Liran();
        l.start();

        for (int i = 0; i < 10; i++){
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Main thread: " + i);
        }


    }
}
