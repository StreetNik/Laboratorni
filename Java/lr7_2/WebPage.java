package com.company;

import java.time.LocalDate;

public abstract class WebPage {
    private String name;
    private String URL;

    public String getName() {
        return name;
    }

    public String getURL() {
        return URL;
    }

    public WebPage(String name, String URL) {
        this.name = name;
        this.URL = URL;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setURL(String URL) {
        this.URL = URL;
    }
    public void printData(){
        System.out.println("Name: " + name + "; ");
        System.out.println("URL: " + URL + "; ");
    }

    public static LocalDate mostPagesDay() throws Exception{
        int max = 0;
        LocalDate date = null;
        for(Visiting o : Visiting.visitings)
            if(o.getCountPages() > max){
                max = o.getCountPages();
                date = o.getDate();
            }
        if(date == null)
            System.out.println("Не було відвідувань");
        return date;
    }

    public static float avarageCountHostPeriod(LocalDate date1, LocalDate date2) throws Exception{
        int sum = 0;
        int count = 0;
        for(Visiting o : Visiting.visitings)
            if(o.getDate().compareTo(date1) > 0 && o.getDate().compareTo(date2) < 0){
                sum += o.getCountUniqHost();
                count++;
            }
        float res;
        return res = (sum / count);
    }

    public static int CheckIfMore(float n){
        int days = 0;
        for(Visiting o : Visiting.visitings)
            if(o.getCountUniqHost() / o.getCountPages() >= n)
                days++;
        return days;
    }
}
