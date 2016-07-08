package com.example.hackeru.listview2;

import java.util.Date;

/**
 * Created by hackeru on 7/7/2016.
 */
public class Student {

    private String name;
    private String phoneNumber;
    private String id;
    private String address;
    private int age;
    private Date birthDate;
    private static int counter = 0;

    public Student(String name, int age){
        this.name = name;
        this.age = age;
        phoneNumber = counter++ + "";
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name + ", " + age;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
}
