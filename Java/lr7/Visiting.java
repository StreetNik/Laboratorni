package com.company;

import java.time.LocalDate;

public class Visiting extends WebPage{
    private LocalDate date;
    private int countUniqHost;
    private int countPages;

    public Visiting(String name, String URL, LocalDate date, int countUniqHost, int countPages) {
        super(name, URL);
        this.date = date;
        this.countUniqHost = countUniqHost;
        this.countPages = countPages;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public int getCountUniqHost() {
        return countUniqHost;
    }

    public void setCountUniqHost(int countUniqHost) {
        this.countUniqHost = countUniqHost;
    }

    public int getCountPages() {
        return countPages;
    }

    public void setCountPages(int countPages) {
        this.countPages = countPages;
    }

    public void setValues(String name, String URL, LocalDate date, int uniq, int pages){
        this.setName(name);
        this.setURL(URL);
        this.countUniqHost = uniq;
        this.countPages = pages;
    }

    @Override
    public void printData(){
        System.out.printf("%-20s", getName());
        System.out.printf("%-20s", getURL());
        System.out.printf("%-15s", getDate());
        System.out.printf("%-15s", getCountUniqHost());
        System.out.printf("%-15s", getCountPages());
        System.out.println("");
    }
}
