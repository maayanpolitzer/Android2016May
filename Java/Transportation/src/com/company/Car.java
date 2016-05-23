package com.company;

/**
 * Created by Hackeru on 5/23/2016.
 */
public class Car {

    private Person owner;
    private String model;
    private int numOfDoors;
    private int hand;

    private static int totalCars;

    public Car(Person carOwner, String carModel, int carDoors){
        owner = carOwner;
        model = carModel;
        numOfDoors = carDoors;
        hand = 1;
        totalCars++;
    }

    public String getCarInfo(){
        String info = owner.getName() + ", " + model + ", " + hand + ", " + numOfDoors;
        return info;
    }

    public Person getOwner() {
        return owner;
    }

    public String setOwner(Person newOwner){
        if (owner != newOwner){
            owner = newOwner;
            hand++;
            return "SOLD!!!!!";
        }
        return "WTF??";
    }

    public int getHand() {
        return hand;
    }

    public String getModel() {
        return model;
    }

    public int getNumOfDoors() {
        return numOfDoors;
    }

    public static int getTotalCars(){
        return totalCars;
    }
}
