package com.company;

/**
 * Created by hackeru on 5/26/2016.
 */
public class MyString {

    private char[] chars;

    public MyString(char[] chars){
        this.chars = chars;
    }

    public void print(){
        for (int i = 0; i < chars.length; i++){
            System.out.print(chars[i]);
        }
        System.out.println();
    }

    public char charAt(int maayan){
        if (maayan < chars.length){
            return chars[maayan];
        }
        throw new IndexOutOfBoundsException();
    }

    public int indexOf(char c){
        for (int i = 0; i < chars.length; i++){
            if (chars[i] == c){
                return i;
            }
        }
        return -1;
    }

    public int howManySameChars(char c) {
        int counter = 0;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == c) {
                counter++;
            }
        }
        return counter;
    }

    public boolean contains(char c){
        return indexOf(c) != -1;
        /*
        if (indexOf(c) != -1){
            return true;
        }
        return false;
        */
    }

    public boolean isLastChar(char c){
        return chars[chars.length - 1] == c;
    }

    public MyString subString(int startIndex){
        char[] cc = new char[chars.length - startIndex];
        for (int i = startIndex; i < chars.length; i++){
            cc[i - startIndex] = chars[i];
        }
        return new MyString(cc);
    }

    public MyString subString(int startIndex, int endIndex){

    }

}
