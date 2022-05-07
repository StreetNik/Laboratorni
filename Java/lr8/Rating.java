package com.company;

import java.util.concurrent.CopyOnWriteArrayList;
import java.util.*;

public class Rating implements rateInterface{
    private String name;
    private int id;
    private int rating;

    public static CopyOnWriteArrayList<Rating> arr = new CopyOnWriteArrayList<Rating>();
    public static ArrayList<Rating> lowAvg = new ArrayList<Rating>();


    @Override
    public void sortAdd() {
        if(arr.size() > 0){
           /* for(Rating o : arr){
                if(o.getRating() < this.getRating())
                    arr.add(arr.indexOf(o), this);
            }*/

            Iterator<Rating> it = arr.iterator();
            while(it.hasNext()){
                Rating o = it.next();
                int index = arr.indexOf(o);
                if(o.getRating() < this.getRating()) {
                    arr.add(index, this);
                }
            }
        }else{
            arr.add(this);
        }
    }

    @Override
    public void ToString() {
            System.out.printf("%-20s", this.getName());
            System.out.printf("%-20s", this.getId());
            System.out.printf("%-15s", this.getRating());
            System.out.println("");
    }

    public static int getAvg(){
        int avg = 0;
        int sum = 0;
        for(Rating o : arr){
            sum+=o.getRating();
        }
        avg = sum / arr.size();
        return avg;
    }

    @Override
    public void lowRating(int avg) {
        if(this.getRating() < avg)
            lowAvg.add(this);
    }

    public Rating(String name, int id, int rating) {
        this.name = name;
        this.id = id;
        this.rating = rating;
        //this.sortAdd();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }
}
