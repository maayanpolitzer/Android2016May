package com.company;

/**
 * Created by hackeru on 5/30/2016.
 */
public abstract class Person {

    private String firstName;
    private String lastName;

    public Person(String firstName, String lastName){
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public void sayHi(){
        System.out.println("hi from person");
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
}
