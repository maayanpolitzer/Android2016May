package com.company;

/**
 * Created by Hackeru on 5/23/2016.
 */
public class Hotel {

    private String manager;
    private Room[] rooms;

    private static int numOfRooms;

    public Hotel(int numOfRooms){
        rooms = new Room[numOfRooms];
    }

    /*
    public void addRoom(Room newRoom){
        //rooms[numOfRooms] = newRoom;
        //numOfRooms++;
        if (numOfRooms < rooms.length){
            rooms[numOfRooms++] = newRoom;
        }
    }
    */

    public void printRooms(){
        for (int i = 0; i < numOfRooms; i++){
            System.out.println(rooms[i].getName());
        }
    }

    public void addNewRoom(String roomName){
        if (numOfRooms < rooms.length){
            /*
            Room r = new Room(roomName);
            rooms[numOfRooms] = r;
            numOfRooms++;
            */
            rooms[numOfRooms++] = new Room(roomName);
        }
    }

    public void changeRoomName(int index, String newName){
        rooms[index].setName(newName);
        //rooms[index] = new Room(newName);  // WRONG!!!! dont create a new room
    }

    public void changeRoomByName(String oldRoomName, String newRoomName){
        for (int i = 0; i < rooms.length; i++){
            if (rooms[i].getName() == oldRoomName){
                rooms[i].setName(newRoomName);
                break;
            }
        }
    }



}
