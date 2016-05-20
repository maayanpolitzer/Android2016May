package com.company;

/**
 * Created by hackeru on 5/19/2016.
 */
public class Cage {

    private Lion[] lions;

    public Cage(int maxCapacity){
        lions = new Lion[maxCapacity];
    }

    public void insertLionToCage(Lion newLion){
        lions[0] = newLion;
    }


}
