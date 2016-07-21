package com.example.hackeru.dateandtimepickerfragments;

/**
 * Created by hackeru on 7/21/2016.
 */
public class FullDate {

    private String date;
    private String time;

    public String getDate() {
        return date;
    }

    public String getTime() {
        return time;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setTime(String time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return date + "," + time;
    }
}
