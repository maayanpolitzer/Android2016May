package com.company;


import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        School hackerU = new School();

        hackerU.add(new Student("Maayan", "Politzer", "Android"));
        hackerU.add(new Guard("Moshe", "Cohen", 8000, "Front"));
        hackerU.add(new Teacher("Shalom", "Levi", 4000, "Android"));

        hackerU.sayHelloToAll();


    }
}
