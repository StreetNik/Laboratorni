package com.company;
import java.time.LocalDate;
import java.util.*;

public class Client {
    private int id;
    private String name;
    private float allcash;

    private ArrayList<Transaction> allSubj = new ArrayList<Transaction>();



    public Client(int id, String name, float allcash){
        this.id = id;
        this.name = name;
        this.allcash = allcash;
    }

    public String getName(){
        return this.name;
    }
    public int getId(){
        return this.id;
    }
    public float getAllcash(){
        return allcash;
    }
    public void makeTransaction(boolean cash, float sum, LocalDate date){
        float rest = this.getAllcash() - sum;
        this.allSubj.add(new Transaction(cash, sum, rest, date));
        this.allcash = rest;
    }

    public void printString(){
        System.out.println("Id: " + id + "; Name: " + name + "; Rest: " + allcash);
    }

    public float sumCash(LocalDate date1, LocalDate date2){
        Scanner scanner = new Scanner(System.in);
        float sum = 0;

        for(Transaction o : allSubj){
            if(o.getCash() && o.getDate().compareTo(date1) > 0 && o.getDate().compareTo(date2) < 0){
                sum+=o.getSum();
            }
        }
        return sum;
    }
}
