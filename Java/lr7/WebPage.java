package com.company;

public class WebPage {
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
}
