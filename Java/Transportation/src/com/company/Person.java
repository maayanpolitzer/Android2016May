package com.company;


import java.time.Year;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by Hackeru on 5/23/2016.
 */
public class Person {

    private String name;
    private int birthYear;
    private boolean license;
    private int id;

    public Person(String personName, int personBirthYear, boolean personLicense, int personId){
        name = personName;
        birthYear = personBirthYear;
        license = personLicense;
        id = personId;
    }

    public String getPersonInfo(){
        return name + ", " + birthYear + ", " + license + ", " + id;
    }

    public int getAge(){
        /*
        //      old way...
        Date today = new Date();
        int year = today.getYear();
        return (year + 1900) - birthYear;
        */

        //      new way...
        Year now = Year.now();
        return now.getValue() - birthYear;
    }

    public String getName(){
        return name;
    }

    public void setName(String newName){
        name = newName;
    }

    public int getBirthYear(){
        return birthYear;
    }

    public boolean isLicense() {
        return license;
    }

    public void setLicense(boolean newLicense){
        license = newLicense;
    }

    public int getId(){
        return id;
    }
}
