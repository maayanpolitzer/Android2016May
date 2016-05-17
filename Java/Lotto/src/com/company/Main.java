package com.company;

import java.util.Random;

public class Main {

    public static void main(String[] args) {
        /*
                //   0   1  2  3  4
        int[] arr = {4, -5, 6, 4, -5};
        int largestSum = largestSum(arr);
        System.out.println(largestSum);         //      should be 10!

        int[] arrayIndexStartEnd = getIndex(arr);       // should be [2,3];     // always new int[2];

        int[] largestArray = largestArray(arr);     //  should be [6,4];
        */

        Random r = new Random();

        int extra = r.nextInt(8) + 1;
        int[] lotto = generateLotto();

        int[] myLotto = {16, 6, 19, 2, 13, 3};
        int myExtra = 8;

        System.out.println("The generated extra is: " + extra);
        System.out.println(checkExtra(extra, myExtra));

        int guesses = checkLotto(lotto, myLotto);       // 0-6

        switch (guesses){
            case 0:
                System.out.println("Losser");
                break;
            case 1:
            case 2:
                System.out.println("not good");
                break;
            case 3:
                System.out.println("WHATTTTTTT 3");
                break;
            case 4:
                System.out.println("WHATTTTTTT 4");
                break;
            case 5:
                System.out.println("5");
                break;
            case 6:
                System.out.println("JACKPOT");
                break;
        }
    }

    public static int checkLotto(int[] lotto, int[] myLotto){
        int rightGuesses = 0;
        for (int i = 0; i < myLotto.length; i++){
            for (int j = 0; j < lotto.length; j++){
                if (myLotto[i] == lotto[j]){
                    rightGuesses++;
                    System.out.println(myLotto[i]);
                }
            }
        }
        return rightGuesses;
    }

    public static boolean checkExtra(int extra, int myExtra){
        return extra == myExtra;
    }

    public static int[] generateLotto(){
        int[] moshe = new int[6];
        Random r = new Random();
        for (int i = 0; i < moshe.length; i++){
            moshe[i] = 1 + r.nextInt(36);
        }
        return moshe;
    }

}
