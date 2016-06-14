package com.company;


import java.util.HashMap;

public class Main {

    public static void main(String[] args) {

        HashMap<String, Double> fruits = new HashMap<>();

        fruits.put("Apple", 8.9);
        fruits.put("Banana", 10.0);
        fruits.put("Orange", 7.8);

        System.out.println(fruits);

        // loop:
        for (String key : fruits.keySet()){
            double price = fruits.get(key);
            price *= 1.17;
            fruits.put(key, price);
        }

        System.out.println(fruits);
    }
}
