package com.company;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        ArrayList<Animal> cats = new ArrayList<>();

        cats.add(new Cat());
        cats.add(new Lion());


        for (int i = 0; i < cats.size(); i++){
            cats.get(i).sendSMS();
        }

    }



}
