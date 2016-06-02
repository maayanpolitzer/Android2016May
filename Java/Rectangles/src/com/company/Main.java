package com.company;

public class Main {

    static boolean[][] arr = new boolean[17][30];

    public static void main(String[] args) {

        //drawVerticalLine(4);
        //drawHorizontalLine(7);
        //drawRect(1,3,5,8);
        //drawRect(3,5,5,8);
        drawSquare(5,5,7);
        //arr[5][8] = true;
        render();
    }

    private static void drawSquare(int top, int left, int length){
        drawRect(top, left, length, length);
    }

    private static void drawRect(int top, int left, int height, int width){
        for (int i = top; i < top + height; i++){
            arr[i][left] = true;
            arr[i][left + width - 1] = true;
        }

        for (int j = left; j < left + width; j++){
            arr[top][j] = true;
            arr[top + height - 1][j] = true;
        }
    }

    private static void drawVerticalLine(int index){
        for (int i = 0; i < arr.length; i++){
            arr[i][index] = true;
        }
    }

    private static void drawHorizontalLine(int index){
        for (int j = 0; j < arr[index].length; j++){
            arr[index][j] = true;
        }
    }

    public static void render(){
        for (int i = 0; i < arr.length; i++){
            for (int j = 0; j < arr[i].length; j++){
                if (arr[i][j]){ //  same as: (arr[i][j] == true)
                    System.out.print("0 ");
                }else{
                    System.out.print("- ");
                }
            }
            System.out.println();
        }
    }

}
