package com.company;


public class Music {
    private String name;
    private String author;
    private String album;
    private int year;
    private float duration;

    Music(String name, String author, String album, int year, float duration){
        this.name = name;
        this.author = author;
        this.album = album;
        this.year = year;
        this.duration = duration;
    }

    public String getAuthor(){
        return this.author;
    }

    public String getName(){
        return this.name;
    }

    public String getAlbum(){
        return this.album;
    }
    public int getYear(){
        return this.year;
    }
    public float getDuration(){
        return this.duration;
    }

    public String toString(){
        return ("Name: " + name + "; Author: " + author + "; Album: " + album + "; Year: " + year + "; Duration: " + duration + ";");
    }

    public void setValues(String name, String author, String album, int year, float duration){
        this.name = name;
        this.author = author;
        this.album = album;
        this.year = year;
        this.duration = duration;
    }

}
