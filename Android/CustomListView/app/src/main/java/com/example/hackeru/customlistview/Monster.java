package com.example.hackeru.customlistview;

import java.util.Calendar;

/**
 * Created by hackeru on 7/4/2016.
 */
public class Monster {

    private int image;
    private String name;
    private String phoneNumber;
    private Calendar dob;

    public Monster(int image, String name, String phoneNumber) {
        this.image = image;
        this.name = name;
        this.phoneNumber = phoneNumber;
        dob = Calendar.getInstance();
    }

    @Override
    public String toString() {
        return image + "";
    }

    public int getImage() {
        return image;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public Calendar getDob() {
        return dob;
    }
}
