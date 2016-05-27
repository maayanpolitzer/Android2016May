package com.company;

public class Main {

    public static void main(String[] args) {

        MyArray arr = new MyArray();

        for (int i = 0; i < 80; i++){
            arr.add(7);
        }

        System.out.println(arr.get(4));


        arr.print();

    }




}
