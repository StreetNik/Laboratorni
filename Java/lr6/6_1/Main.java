package com.company;

import java.nio.charset.Charset;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static ArrayList<Client> arr = new ArrayList<Client>();

    public static void fillData(){
        //1 ------------
        Client cli1 = new Client(1, "Stas", 5000);
        arr.add(cli1);
        cli1.makeTransaction(true, 300, LocalDate.parse("2022-01-01"));
        cli1.makeTransaction(false, 1000, LocalDate.parse("2022-04-10"));
        cli1.makeTransaction(true, 400, LocalDate.parse("2022-01-05"));
        //2 ------------
        Client cli2 = new Client(2, "Maks", 5000);
        arr.add(cli2);
        cli2.makeTransaction(true, 500, LocalDate.parse("2022-01-05"));
        cli2.makeTransaction(false, 1000, LocalDate.parse("2022-04-10"));
        cli2.makeTransaction(true, 100, LocalDate.parse("2022-01-02"));
        //3 ------------
        Client cli3 = new Client(3, "And", 5000);
        arr.add(cli3);
        cli3.makeTransaction(true, 250, LocalDate.parse("2022-05-15"));
        cli3.makeTransaction(false, 1000, LocalDate.parse("2022-04-10"));
        cli3.makeTransaction(true, 700, LocalDate.parse("2022-04-20"));
        //4 ------------
        Client cli4 = new Client(4, "Mark", 5000);
        arr.add(cli4);
        cli4.makeTransaction(true, 150, LocalDate.parse("2022-03-17"));
        cli4.makeTransaction(false, 1000, LocalDate.parse("2022-04-10"));
        cli4.makeTransaction(true, 220, LocalDate.parse("2022-07-10"));
        //5 ------------
        Client cli5 = new Client(5, "Luc", 5000);
        arr.add(cli1);
        cli1.makeTransaction(true, 600, LocalDate.parse("2022-01-05"));
    }

    public static  void addClient(){
        Scanner s = new Scanner(System.in);
        System.out.println("Введіть ід: ");
        int id = Integer.parseInt(s.nextLine());
        System.out.println("Введіть імя: ");
        String name = s.nextLine();
        System.out.println("Введіть кількість грошей на рахунку: ");
        float allCash = s.nextFloat();
        arr.add(new Client(id, name, allCash));
    }

    public static void addTransaction(){
        Scanner s = new Scanner(System.in);
        System.out.println("Введіть ід: ");
        int id = Integer.parseInt(s.nextLine());
        for (Client o: arr) {
            if(o.getId() == id){
                System.out.println("Cash?");
                boolean cash = Boolean.parseBoolean(s.nextLine());
                System.out.println("Input sum: ");
                float sum = Float.parseFloat(s.nextLine());
                System.out.println("Input date(yyyy-mm-dd): ");
                String date1 = s.next();
                LocalDate date = LocalDate.parse(date1);
                o.makeTransaction(cash, sum, date);
            }
        }
    }

    public static void showClientData(LocalDate date1, LocalDate date2){
        int id = 0;
        float big = 0;
        for(Client o : arr){
            if(o.sumCash(date1, date2) > big){
                big = o.sumCash(date1, date2);
                id = o.getId();
            }
        }
        for(Client c : arr)
            if(c.getId() == id){
                c.printString();
                System.out.println("Sum cash: " + c.sumCash(date1, date2));
            }
    }


    public static void main(String[] args) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        boolean loop = true;
        Scanner scanner = new Scanner(System.in);
        while (loop){
            System.out.println("[1]->Додати клієнта,[2]->Провести перевід,[3] -> Вивести дані про користувача");
            String choice = scanner.next();
            switch (choice){
                case "1":
                    addClient();
                    break;
                case "2":
                    addTransaction();
                    break;
                case "3":
                    System.out.print("Введіть діапазон(yyyy-mm-dd): ");
                    String date11 = scanner.next();
                    System.out.print("Введіть діапазон(yyyy-mm-dd): ");
                    String date12 = scanner.next();
                    LocalDate date1 = LocalDate.parse(date11);
                    LocalDate date2 = LocalDate.parse(date12);
                    showClientData(date1, date2);
                    break;
                case "4":
                    fillData();
                    break;
                default:
                    System.out.println("Незрозуміла команда");
                    break;
                case "0":
                    loop = false;
                    break;
            }
        }
    }
}
