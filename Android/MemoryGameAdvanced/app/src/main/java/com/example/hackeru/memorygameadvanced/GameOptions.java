package com.example.hackeru.memorygameadvanced;

/**
 * Created by hackeru on 6/30/2016.
 */
public class GameOptions {

    private int rows;
    private int columns;

    public GameOptions(int rows, int columns){
        this.rows = rows;
        this.columns = columns;
    }

    public int getRows() {
        return rows;
    }

    public int getColumns() {
        return columns;
    }
}
