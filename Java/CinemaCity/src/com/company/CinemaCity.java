package com.company;

/**
 * Created by Hackeru on 5/23/2016.
 */
public class CinemaCity {

    private Hall mainHall;

    public CinemaCity(){

    }

    public void addHall(int numOfSeats){
        if (mainHall == null){
            mainHall = new Hall(numOfSeats);
        }
    }

    public int buyTicket(){
        return mainHall.buyTicket();
    }

    public void printHall(){
        boolean[] seats = mainHall.getSeats();
        String status = "";
        for (int i = 0; i < seats.length; i++){
            if (seats[i]){
                // seat is taken...
                status += "0";
            }else{
                status += "X";
            }
        }
        System.out.println(status);
    }
}
