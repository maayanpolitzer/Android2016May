package com.company;

/**
 * Created by hackeru on 6/9/2016.
 */
public class Word {

    private String hebrew;
    private String english;

    public Word(String hebrew, String english){
        this.english = english;
        this.hebrew = hebrew;
    }

    public String getEnglish() {
        return english;
    }

    public String getHebrew() {
        return hebrew;
    }
}
