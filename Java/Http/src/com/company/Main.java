package com.company;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

public class Main {

    public static void main(String[] args) {

        String web = "http://mavir.co.il/israel/ramat_gan";
        try {
            URL url = new URL(web);
            InputStream inputStream = url.openStream();
            InputStreamReader in = new InputStreamReader(inputStream);
            BufferedReader reader = new BufferedReader(in);
            String line;    // line = null;
            while ((line = reader.readLine()) != null){
                if (line.contains("כרגע")){
                    getTemp(line);
                    break;
                }
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void getTemp(String line){
        System.out.println(line);
        char first = '+';
        char end = '&';
        String temp = line.substring(line.indexOf(first) + 1, line.indexOf(end));
        System.out.println("The tempeture is: " + temp);
    }
}
