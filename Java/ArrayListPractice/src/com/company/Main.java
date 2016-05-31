package com.company;

public class Main {

    public static void main(String[] args) {

        FaceBook faceBook = new FaceBook();
        faceBook.addUser("maayan", "123");
        faceBook.addUser("moshe", "124");
        System.out.println(faceBook.userCount());

        //faceBook.removeUser("moshe");

        faceBook.getUser("maayan");

        faceBook.sendMessage(faceBook.getUser("maayan"), faceBook.getUser("moshe"), "WHATS'UP!!!!!!!!");
        faceBook.sendMessage(faceBook.getUser("maayan"), faceBook.getUser("moshe"), "how r u?");

        faceBook.getMyMessages("moshe");

    }
}
