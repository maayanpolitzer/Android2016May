package com.company;

public class Main {

    public static void main(String[] args) {

        Hotel maayanHotel = new Hotel(4);
        /*
        Room r1 = new Room("Play Room");
        maayanHotel.addRoom(r1);
        Room r2 = new Room("Food Room");
        maayanHotel.addRoom(r2);
        Room r3 = new Room("Theater");
        maayanHotel.addRoom(r3);
        Room r4 = new Room("Gym");
        maayanHotel.addRoom(r4);
        Room r5 = new Room("Private Room");
        maayanHotel.addRoom(r5);
        */
        maayanHotel.addNewRoom("Play Room");
        maayanHotel.addNewRoom("Food Room");
        maayanHotel.addNewRoom("Theater");
        maayanHotel.addNewRoom("Gym");

        maayanHotel.printRooms();

        // change room name from play room to private room.
        maayanHotel.changeRoomName(0, "Private Room");
        maayanHotel.changeRoomByName("Theater", "Improved Theater");

        maayanHotel.printRooms();

    }
}
