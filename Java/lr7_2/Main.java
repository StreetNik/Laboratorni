package com.company;
import java.time.LocalDate;
import java.util.*;
import java.io.*;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void readFromFileVisiting() throws Exception{
        BufferedReader reader = new BufferedReader(new FileReader("visiting.txt"));
        Visiting.visitings.removeAll(Visiting.visitings);
        String line;
        String[] subStr;

        while((line = reader.readLine())!=null){
            subStr = line.split("; ");
            Visiting.visitings.add(new Visiting(subStr[0], subStr[1], LocalDate.parse(subStr[2]), Integer.parseInt(subStr[3]), Integer.parseInt( subStr[4])));
        }
    }

    public static void writeToFileVisiting() throws Exception{
        File file = new File("visiting.txt");
        file.createNewFile();
        FileWriter writer = new FileWriter(file);
        for(Visiting o : Visiting.visitings){
            writer.write(o.getName()+ "; " + o.getURL() + "; " + o.getDate() + "; " + o.getCountUniqHost() + "; " + o.getCountPages() +"\n");
        }
        writer.flush();
        writer.close();
    }

    public static void addVisiting() throws Exception{
        Scanner s = new Scanner(System.in);

        System.out.println("Введіть назву: "); String name = s.nextLine();
        System.out.println("Введіть URL: "); String URL = s.nextLine();
        System.out.println("Введіть дату: "); LocalDate date = LocalDate.parse(s.nextLine());
        System.out.println("Введіть ксть унікальних хостів: "); int countUniqHost = Integer.parseInt(s.nextLine());
        System.out.println("Введіть ксть завантажених сторінок: "); int countPages = Integer.parseInt(s.nextLine());

        Visiting.visitings.add(new Visiting(name, URL, date, countUniqHost, countPages));
        writeToFileVisiting();
    }

    public static void PrintData(){
        System.out.printf("%-20s", "Назва");
        System.out.printf("%-20s", "URL");
        System.out.printf("%-15s", "Дата");
        System.out.printf("%-15s", "Ксть хостів");
        System.out.printf("%-15s", "Ксть сторінок");
        System.out.println("");
        for(Visiting o : Visiting.visitings)
            o.printData();
        System.out.println("");
    }

    public static void RemoveDataVisiting() throws Exception {
        Scanner s = new Scanner(System.in);
        System.out.println("Введіть url сайта для видалення: "); String URL = s.nextLine();

        Visiting.visitings.removeIf(t -> t.getURL().equals(URL));
        PrintData();
        writeToFileVisiting();
    }

    public static void EditDataVisiting() throws Exception{
        Scanner s = new Scanner(System.in);
        System.out.println("Введіть url сайта для редагування: "); String URL = s.nextLine();

        System.out.println("Введіть новий URL: ");String nURL = s.nextLine();
        System.out.println("Введіть нову назву: ");String name = s.nextLine();
        System.out.println("Введіть нову дату: ");LocalDate date = LocalDate.parse(s.nextLine());
        System.out.println("Введіть нову ксть хостві: ");int countUniqHosts = Integer.parseInt(s.nextLine());
        System.out.println("Введіть нову ксть прогружених сторінок: ");int countPages = Integer.parseInt(s.nextLine());

        boolean found = false;

        for(Visiting o : Visiting.visitings){
            if(o.getURL().equals(URL)){
                found = true;
                o.setValues(name, nURL, date, countUniqHosts, countPages);
            }
            if(!found){
                System.out.println("Not found");
            }else{
                writeToFileVisiting();
            }
        }
    }

    public static void main(String[] args) throws Exception {
        Scanner s = new Scanner(System.in);
        boolean loop = true;
        while(loop){
            readFromFileVisiting();
            System.out.println(" 1: Добавлення відвідування, 2: Вивести дані, 3: Редагувати відвідування, 4: Видалити 5: Завдання1, 6: Завдання2, 7: Завдання3");
            int n = s.nextInt();
            switch(n){
                case 1:
                    addVisiting();
                    break;
                case 2:
                    PrintData();
                    break;
                case 3:
                    EditDataVisiting();
                    break;
                case 4:
                    RemoveDataVisiting();
                    break;
                case 5:
                    System.out.println("Введіть початкову дату: ");
                    String str1 = s.next();
                    LocalDate date1 = LocalDate.parse(str1);
                    System.out.println("Введіть кінцеву дату: ");
                    String str2 = s.next();
                    LocalDate date2 = LocalDate.parse(str2);
                    System.out.println(Visiting.avarageCountHostPeriod(date1, date2));
                    break;
                case 6:
                    System.out.println(Visiting.mostPagesDay());
                    break;
                case 7:
                    float b = s.nextFloat();
                    System.out.println(Visiting.CheckIfMore(b));
                    break;
                case 8:
                    loop = false;
                    break;
            }
        }
    }
}
