package com.company;

/**
 * Created by hackeru on 5/19/2016.
 */
public class ClassRoom {

    private String name;
    private int tables;

    public ClassRoom(String className){
        name = className;
    }

    public String getName() {
        return name;
    }

    public void addTables(int numOfTables){
        tables = numOfTables;
    }
}
