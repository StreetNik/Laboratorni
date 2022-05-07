package com.company;

import java.util.concurrent.CopyOnWriteArrayList;
import java.util.*;

public abstract class Doctor implements InterfaceDoctor{
    private String name;
    private String fah;

    public static CopyOnWriteArrayList<Apointment> apointments = new CopyOnWriteArrayList<Apointment>();

    public Doctor(String name, String fah) {
        this.name = name;
        this.fah = fah;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFah() {
        return fah;
    }

    public void setFah(String fah) {
        this.fah = fah;
    }

    @Override
    public int lengthOfName() {
        return this.getName().length();
    }

    @Override
    public int countVisitors(){
        int count = 0;
        for(Apointment o : apointments){
            if(this.getName() == o.getName()){
                count += o.getVisitors();
            }
        }
        return count;
    }

    public static void Print(){
        for(Apointment o : apointments){
            System.out.printf("%-20s", o.getName());
            System.out.printf("%-20s", o.getFah());
            System.out.printf("%-20s", o.getDate());
            System.out.printf("%-20s", o.getZmina());
            System.out.printf("%-20s", o.getVisitors());
            System.out.println("");
        }
    }
}
