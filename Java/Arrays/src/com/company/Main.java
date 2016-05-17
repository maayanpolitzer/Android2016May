package com.company;


public class Main {

    public static void main(String[] args){

        int[] tom = new int[50];
        for (int i = 0 ; i < tom.length; i++){
            tom[i] = 88;
        }

        int average = getAverage(tom);
        System.out.println("The average is: " + average);

        String[] cities = new String[]{"Metula", "Haifa", "Tel-aviv", "Beer-sheva", "Eilat"};
        String[] reverseArr = flip(cities);

        int[] arr = {5,-3,5,-4,7,-44,8,3,6,3,7};
        int max = getMax(arr);


        //System.out.println(tom[0]);
        /*
        for (int i = 0; i < tom.length; i++){
            tom[i]++;
        }

        for (int i = 0; i < tom.length; i++){
            System.out.println(tom[i]);
        }
        */




        //boolean[] adi = new boolean[76];


    }

    public static int getAverage(int[] maayan){
        int sum = 0;
        for (int i = 0; i < maayan.length; i++){
            sum += maayan[i];
        }
        return sum / maayan.length;
    }

    public static String[] flip(String[] yossi){
        String[] maayan = new String[yossi.length];
        int counter = yossi.length - 1;
        for (int i = 0; i < yossi.length; i++){
            maayan[i] = yossi[counter - i];
        }
        return maayan;
    }

    public static int getMax(int[] arr){
        int max = arr[0];
        for (int i = 1; i < arr.length; i++){
            if (arr[i] > max){
                max = arr[i];
            }
        }
        return max;
    }

}
