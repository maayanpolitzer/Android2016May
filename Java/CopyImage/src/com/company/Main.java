package com.company;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;


public class Main {

    public static void main(String[] args) {

        copyImageFile();

    }

    private static void copyImageFile(){
        File image = new File("image.jpg");     // pointer
        File newImage = new File("newImage.jpg");

        FileInputStream in = null;
        FileOutputStream out = null;


        try{
            in = new FileInputStream(image);    //      open connection to read.
            out = new FileOutputStream(newImage);   // open connection to write.

            byte[] buffer = new byte[1024];
            int length = 0;
            while((length = in.read(buffer)) > 0){
                out.write(buffer, 0, length);
            }

        }catch(Exception e){

        }finally {
            if (in != null){
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (out != null){
                try {
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }


    }
}
