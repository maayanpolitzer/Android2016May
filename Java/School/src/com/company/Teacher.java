package com.company;

/**
 * Created by hackeru on 5/30/2016.
 */
public class Teacher extends Employee {

    private String className;

    public Teacher(String firstName, String lastName, int salary, String className) {
        super(firstName, lastName, salary);
        this.className = className;
    }

    public String getClassName() {
        return className;
    }
}
