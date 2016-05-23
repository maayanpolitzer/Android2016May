package com.company;

/**
 * Created by Hackeru on 5/23/2016.
 */
public class Hall {

    private boolean[] seats;

    public Hall(int numOfSeats){
        seats = new boolean[numOfSeats];
    }

    public int buyTicket(){
        for (int i = 0; i < seats.length; i++){
            if(!seats[i]){      //  The same as: (seats[i] == false)
                seats[i] = true;
                return i;
            }
        }
        return -1;      //      hall is FULL!!!
    }

    public boolean[] getSeats(){
        return seats;
    }

}
