package com.company;

public class Main {

    public static void main(String[] args) {

        int number = product(5,34);
        System.out.println(number);

        System.out.println(quatient(7, 0));        //  2

        boolean b = false;
        System.out.println(isTrue(b));
        getMax(6534234, -3453468);   // print the largest number.

        System.out.println(reminder(10,4));

        System.out.println(power(8,2)); // 64
        System.out.println(sqrt(50));  // 7

    }

    public static int reminder(int x, int y){
        return distance(x,product(quatient(x,y),y));
    }

    public static String isTrue(boolean x){
        if (x) {      // the same as: if(moshe==true){
            return "Yes";
        }
        return "No";
    }

    public static void getMax(int x, int y){
        if (x > y){
            System.out.println(x);
        }else{
            System.out.println(y);
        }
    }

    public static int quatient(int x, int y){
        if (y == 0){
            return -1;
        }
        int count = 0;
        int num = y;
        while(num <= x){
            count++;
            num+= y;
        }
        return count;
    }

    public static int getSum(int x, int y){
        // return x + y;
        int sum = x + y;
        return sum;
    }

    public static int distance(int x, int y){
        int small = x;
        int large = y;
        if (small > large){
            small = y;
            large = x;
        }
        int distance = 0;
        for (int i = small + distance; i < large; i++){
            distance++;
        }
        return distance;
    }

    public static int product(int x, int y){
        int small = x;
        int large = y;
        if (small > large){
            small = y;
            large = x;
        }
        int product = 0;
        for (int i = 0; i < small; i++){
            product += large;
        }
        return product;
    }


}
