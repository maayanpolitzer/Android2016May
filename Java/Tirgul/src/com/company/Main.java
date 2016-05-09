package com.company;

public class Main {

    public static void main(String[] args) {

        int firstNumber = 16;
        int secondNumber = 120;
        int distance = 0;

        int smallNumber = firstNumber;
        int largeNumber = secondNumber;

        if (smallNumber > largeNumber){
            smallNumber = secondNumber;
            largeNumber = firstNumber;
        }

        for (int i = smallNumber + distance; i < largeNumber; i++){
            distance++;
        }

        System.out.println("The distance between " + firstNumber + " and " + secondNumber + " is: " + distance);

    }
}
