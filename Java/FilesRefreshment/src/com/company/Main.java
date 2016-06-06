package com.company;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        /*
              //create new files...
        String[] fileNames = new String[]{"maayanFile.txt", "maayanFile2.txt"};
        for (int i = 0; i < fileNames.length; i++){
            createFile(fileNames[i]);
        }
        */

        //createFileAndInsertData("maayan.txt", "Hello, World!");

        //appendToFile("maayan.txt", "appended content...\ndfbvgjdldfkn\nsfljknsdflksdnf\n\n\ndfkljdndfn");

        //readFromFile("maayan.txt");

        copyImage("a.jpg");

    }

    private static void copyImage(String fileName){
        File dir = new File("C:\\Users\\hackeru\\Desktop", "niceImage");
        dir.mkdir();    //      create a folder on desktop...
        File original = new File(fileName); //  pointer to the original image (a.jpg).
        File newImage = new File(dir, "copy.jpg");
        FileInputStream in = null;
        FileOutputStream out = null;
        try {
            in = new FileInputStream(original);
            out = new FileOutputStream(newImage);

            byte[] bytes = new byte[1024];
            int length = 0;

            while ((length = in.read(bytes)) > 0){
                out.write(bytes, 0, length);
            }
            System.out.println("DONE!!!");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
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

    private static void readFromFile(String fileName){
        File f = new File(fileName);        // pointer to FILE_NAME
        if (f.exists()){
            try {
                FileInputStream in = new FileInputStream(f);
                BufferedReader reader = new BufferedReader(new InputStreamReader(in));
                String line = null;
                while ((line = reader.readLine()) != null){
                    System.out.println(line);
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static void appendToFile(String fileName, String content){
        File f = new File(fileName);     // pointer to FILE_NAME.
        if (f.exists()){
            try {
                FileWriter writer = new FileWriter(fileName, true);
                writer.write(content);
                writer.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static void createFile(String fileName){
        File file = new File(fileName);
        try {
            if (!file.exists()) {       //  if file NOT exists, create a new one.
                file.createNewFile();
            }else{
                System.out.println(fileName + " already exists...");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void createFileAndInsertData(String fileName, String content){
        createFile(fileName);               // create new file FILE_NAME
        File f = new File(fileName);        // get pointer to FILE_NAME
        byte[] bytes = content.getBytes();
        FileOutputStream out = null;
        try {
            out = new FileOutputStream(f);
            out.write(bytes);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
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
