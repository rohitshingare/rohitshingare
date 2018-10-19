package com.example.dell.dishservices.cart;

/**
 * Created by DELL on 27-03-2018.
 */

public class Album {
    private String name;
    private int nameOfSongs;
    private int thumbail;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNameOfSongs() {
        return nameOfSongs;
    }

    public void setNameOfSongs(int nameOfSongs) {
        this.nameOfSongs = nameOfSongs;
    }

    public int getThumbail() {
        return thumbail;
    }

    public void setThumbail(int thumbail) {
        this.thumbail = thumbail;
    }

    public  Album()
    {

    }
    public Album(String name, int nameOfSongs, int thumbail) {
        this.name = name;
        this.nameOfSongs = nameOfSongs;
        this.thumbail = thumbail;
    }
}
