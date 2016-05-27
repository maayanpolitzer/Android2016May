package com.company;

/**
 * Created by hackeru on 5/26/2016.
 */
public class MyArray {

    private int[] arr;  // always 10;
    private int addAmount;  // a real size(by add method);

    public MyArray(){
        arr = new int[10];
    }

    public void add(int x){
        /*
        if (addAmount < arr.length){
            arr[addAmount] = x;
            addAmount++;
        } else {
            makeRoom();
            add(x);
        }
        */
        if (addAmount == arr.length){
            makeRoom();
        }
        arr[addAmount++] = x;
    }

    private void makeRoom(){
        System.out.println("Making room...");
        int[] temp = new int[addAmount * 2];
        for (int i = 0; i < addAmount; i++){
            temp[i] = arr[i];
        }
        arr = temp;
    }

    public void print(){
        System.out.print("[");
        for (int i = 0; i < addAmount; i++){
            if (i == addAmount - 1){
                System.out.print(arr[i]);
            }else{
                System.out.print(arr[i] + ",");
            }
        }
        System.out.println("]");
    }

    public int get(int index){
        if (index < addAmount){
            return arr[index];
        }
        throw new IndexOutOfBoundsException();
    }

    public int average(){
        int sum = 0;
        for (int i = 0; i < addAmount; i++){
            sum += arr[i];
        }
        return sum / addAmount;
    }

    public int[] toArray(){
        int[] temp = new int[addAmount];
        for (int i = 0; i < addAmount; i++){
            temp[i] = arr[i];
        }
        return temp;
    }

}
