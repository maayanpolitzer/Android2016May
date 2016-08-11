package com.example.hackeru.fragmentsadvanced;

import java.io.Serializable;

/**
 * Created by Hackeru on 11/08/2016.
 */
public class Monster implements Serializable {

    private String name;
    private int icon;

    public Monster(String name, int icon){
        this.name = name;
        this.icon = icon;
    }

    public String getName() {
        return name;
    }

    public int getIcon() {
        return icon;
    }

    @Override
    public String toString() {
        return name;
    }
}
