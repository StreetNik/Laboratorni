package com.company;
import java.time.format.DateTimeFormatter;
import java.time.LocalDate;

public class Transaction {

    private LocalDate date;
    private boolean cash;
    private float sum;
    private float rest;



    public Transaction(boolean cash, float sum, float rest, LocalDate date){
        this.date = date;
        this.cash = cash;
        this.sum = sum;
        this.rest = rest;
    }



    public LocalDate getDate(){
        return this.date;
    }

    public boolean getCash(){
        return this.cash;
    }

    public Float getSum(){
        return this.sum;
    }
    public Float getRest(){
        return this.rest;
    }

}
