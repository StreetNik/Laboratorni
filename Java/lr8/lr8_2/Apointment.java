package com.company;

import java.time.LocalDate;
import java.util.ArrayList;

public class Apointment extends Doctor{
    private LocalDate date;
    private String zmina;
    private int visitors;

    public Apointment(String name, String fah, LocalDate date, String zmina, int visitors) {
        super(name, fah);
        this.date = date;
        this.zmina =zmina;
        this.visitors = visitors;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getZmina() {
        return zmina;
    }

    public void setZmina(String zmina) {
        this.zmina = zmina;
    }

    public int getVisitors() {
        return visitors;
    }

    public void setVisitors(int visitors) {
        this.visitors = visitors;
    }

    public static void min(){
        int min = 100;
        Apointment a = null;
        for(Apointment o : Doctor.apointments){
            if(o.getVisitors() < min){
                min = o.getVisitors();
                a = o;
            }
        }
        System.out.println("Прийом з найменшою кількістю відвідувачів відбувся: " + a.getDate());
    }


}
