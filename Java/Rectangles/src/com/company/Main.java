package com.company;

public class Main {

    static boolean[][] arr = new boolean[10][30];

    public static void main(String[] args) {

        //drawVerticalLine(4);
        drawRect(1,3,4,5);
        arr[5][8] = true;
        render();
    }

    public static void render(){
        for (int i = 0; i < arr.length; i++){
            for (int j = 0; j < arr[i].length; j++){
                if (arr[i][j]){ //  same as: (arr[i][j] == true)
                    System.out.print("0");
                }else{
                    System.out.print("-");
                }
            }
            System.out.println();
        }
    }

}
