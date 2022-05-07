package com.company;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;

public class Main {
    public static void readFromFile() throws Exception{
        BufferedReader reader = new BufferedReader(new FileReader("rating.txt"));
        Rating.arr.removeAll(Rating.arr);
        String line;
        String[] subStr;

        while((line = reader.readLine())!=null){
            subStr = line.split("; ");
            Rating.arr.add(new Rating(subStr[0], Integer.parseInt(subStr[1]), Integer.parseInt(subStr[2])));
        }
    }

    public static void writeToFile() throws Exception{
        File file = new File("rating.txt");
        file.createNewFile();
        FileWriter writer = new FileWriter(file);
        for(Rating o : Rating.arr){
            writer.write(o.getName()+ "; " + o.getId() + "; " + o.getRating() +"\n");
        }
        writer.flush();
        writer.close();
    }

    public static void addStudent() throws Exception {
        Scanner s = new Scanner(System.in);
        System.out.println("Введіть імя студента: "); String name = s.next();
        System.out.println("Введіть номер залікової книжки студента: "); int id = s.nextInt();
        System.out.println("Введіть рейтинг студента: "); int rating = s.nextInt();

        new Rating(name, id, rating).sortAdd();
        writeToFile();
    }

    public static void printData(){
        for(Rating o : Rating.arr)
            o.ToString();
    }

    public static void Edit(int n) throws Exception {
        Scanner s = new Scanner(System.in);
        for(Rating o : Rating.arr){
            if(o.getId() == n){
                String name = s.next(); o.setName(name);
                int id = s.nextInt(); o.setId(id);
                int rating = s.nextInt(); o.setRating(rating);
            }
        }
        writeToFile();
    }

    public static void Remove(int id) throws Exception {
        for(Rating o : Rating.arr){
            if(o.getId() == id){
                Rating.arr.remove(o);
            }
        }
        writeToFile();
    }

    public static void main(String[] args) throws Exception {
        Scanner s = new Scanner(System.in);
        readFromFile();
        boolean loop = true;
        while(loop){
            System.out.println("1: Добавити студента, 2: Вивксти дані, 3: Середній рейтинг групи, 4: Редагувати дані, 5: Видалити дані");
            int n = s.nextInt();
            switch (n){
                case 1:
                    addStudent();
                    break;
                case 2:
                    printData();
                    break;
                case 3:
                    int avg = Rating.getAvg();
                    for(Rating o :Rating.arr){
                        o.lowRating(avg);
                    }
                    System.out.println("Avg rating: " + avg + "; Low avg students: " + Rating.lowAvg.size());
                    break;
                case 4:
                    int id = s.nextInt();
                    Edit(id);
                    break;
                case 5:
                    int id1 = s.nextInt();
                    Remove(id1);
            }
        }
    }
}
