package com.company;


import java.io.*;

public class Main {

    public static void main(String[] args) {

        /*
        File dir = new File("myFolder");    // create object from File class.
        dir.mkdir();        //      create a real folder!!!

        File f = new File(dir,"file1.txt");     // create object from File class.

        try {
            f.createNewFile();      // create REAL file in "dir" folder.
        } catch (Exception e) {
            System.out.println(e.getMessage());        //  if "try" block failed.
        }

        /*
        File myFile = new File("maayanFile2.txt");

        try{
            myFile.createNewFile();
        }catch(Exception e){
            System.out.println("Problem: " + e.getMessage());
        }
*/

        // insert data to file.
        // by char, by byte

        /*
        byte b = 127;   //  -128 -> 127;
        short s = 32767;    //  -32768 -> 32767;
        int i = 2147483647; //  -2147483648  -> 2147483647;
        */


        //writeToFile(file);

        //appendToFile();

        readFromFile();


    }

    private static void appendToFile(){
        try {
            FileWriter writer = new FileWriter("Maayan.txt", true);
            writer.write(" ");
            writer.flush();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void readFromFile(){
        try {
            /*
            FileInputStream in = new FileInputStream("Maayan.txt"); //  open connection to read from file.
            InputStreamReader in2 = new InputStreamReader(in);
            BufferedReader reader = new BufferedReader(in2);   // reads line by line...
            */

            BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream("Maayan.txt")));
            //String line = reader.readLine();      //      read one line.
            String line = null;
            while((line = reader.readLine()) != null){
                System.out.println(line);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void writeToFile(File file){

        try {
            file.createNewFile();
        } catch (IOException e) {
            System.out.println("Big big problem...");
        }
        if (file.exists()){
            // start inserting data...
            String content = "maa an";
            byte[] bytes = content.getBytes();      // convert String to byte[].
            FileOutputStream out = null;
            try {
                out = new FileOutputStream(file);      // open connection to write data.
                out.write(bytes);                      // write the data.
            }catch (Exception e){
                System.out.println("Problem");
            }finally {
                if (out != null) {
                    try {
                        out.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
