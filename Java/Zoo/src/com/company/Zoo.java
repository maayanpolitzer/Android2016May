package com.company;

/**
 * Created by hackeru on 5/19/2016.
 */
public class Zoo {

    private Cage lionsCage;     //  null;
    private String manager = "Maayan politzer";

    public String getManager(){
        return manager;
    }

    public void addCage(int maxCapacity){
        lionsCage = new Cage(maxCapacity);
    }

    public void addLion(){
        /*
        Lion simba = new Lion();
        lionsCage.insertLionToCage(simba);
        */
        lionsCage.insertLionToCage(new Lion());
    }

}
