package com.company;

/**
 * Created by hackeru on 5/30/2016.
 */
public class Guard extends Employee {

    private String gate;

    public Guard(String firstName, String lastName, int salary, String gate) {
        super(firstName, lastName, salary);
        this.gate = gate;
    }

    public String getGate() {
        return gate;
    }
}
