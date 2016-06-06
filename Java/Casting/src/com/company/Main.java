package com.company;

public class Main {

    public static void main(String[] args) {
        /*
        float f = 5.674454f;
        long l = 1586795876394568731L;
        */

        // convert upward:
        int i2 = 495634596;
        long y = i2;

        byte b = 56;
        int k = b;

        /*
        //convert downward;
        //casting
        long l = 548578475845760L;
        int j = (int) l;
        //System.out.println(j);

        byte ff = (byte) l;
        System.out.println(ff);
        */

        // helper classes:

        long l = 548578475845760L;
        Long lobj = new Long(l);
        int j = lobj.intValue();

        byte[] brr = convertToBytes("maayan");
        for (int i = 0; i < brr.length; i++){
            System.out.println(brr[i]);
        }

        System.out.println(toUpperCase("m-Ayan"));

    }

    private static String toUpperCase(String content){
        char[] chars = new char[content.length()];

        for (int i = 0; i < chars.length; i++){
            char c = content.charAt(i);
            byte b = (byte) c;
            if (b >= 97 && b <= 122){
                b -= 32;
                c = (char) b;
            }
            chars[i] = c;
        }

        return new String(chars);
    }

    private static byte[] convertToBytes(String content){
        byte[] bytes = new byte[content.length()];
        for (int i = 0; i < bytes.length; i++){
            char c = content.charAt(i);
            byte b = (byte) c;
            bytes[i] = b;
        }
        return bytes;
    }
}
