package com.company;

/**
 * Created by hackeru on 5/19/2016.
 */
public class College {

    private ClassRoom[] kitot;

    public College(int numOfClasses){
        kitot = new ClassRoom[numOfClasses];
    }

    public void addKita(String firstName, String secondName){
        kitot[0] = new ClassRoom(firstName);
        kitot[1] = new ClassRoom(secondName);
    }

    public void printKitot(){   //  get...
        for(int i = 0; i < kitot.length; i++){
            System.out.println(kitot[i].getName());
        }
    }

    public void insertTableToClass(int classRoom, int numOfTables){
        kitot[classRoom].addTables(numOfTables);
    }


}
