package com.company;

public class Main {

    public static void main(String[] args) {

        CinemaCity cinemaCity = new CinemaCity();
        cinemaCity.addHall(7);

        System.out.println(cinemaCity.buyTicket());
        cinemaCity.printHall();

    }
}
