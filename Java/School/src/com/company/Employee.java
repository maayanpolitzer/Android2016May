package com.company;

/**
 * Created by hackeru on 5/30/2016.
 */
public abstract class Employee extends Person {

    private int salary;

    public Employee(String firstName, String lastName, int salary){
        super(firstName, lastName);
        this.salary = salary;
    }

    public int getSalary() {
        return salary;
    }
}
