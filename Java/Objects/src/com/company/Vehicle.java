package com.company;


/**
 * Created by hackeru on 5/19/2016.
 */
public class Vehicle {

    private static int soldVehicles;

    private String color;
    private String model;

    private int numOfWheels;
    private int numOfDoors;
    private int price;
    private int maxSpeed;
    private int year;

    private boolean manual;

    public Vehicle(String vehicleModel, String vehicleColor, int vehicleWheels,
                   int vehicleDoors, int vehiclePrice, int vehicleMax, int vehicleYear,
                   boolean vehicleManual){   // constructor...
        model = vehicleModel;
        color = vehicleColor;
        numOfWheels = vehicleWheels;
        numOfDoors = vehicleDoors;
        price = vehiclePrice;
        maxSpeed = vehicleMax;
        year = vehicleYear;
        manual = vehicleManual;
    }

    public void setPrice(int newPrice){
        price = newPrice;
    }

    public int getPrice(){
        return price;
    }

    public int getYear(){
        return year;
    }

    public void setColor(String newColor){
        color = newColor;
    }

}
