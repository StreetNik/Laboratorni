package com.company;
import java.time.LocalDate;
import java.util.*;
import java.io.*;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static ArrayList<WebPage> webPages = new ArrayList<>();
    public static ArrayList<Visiting> visitings = new ArrayList<>();

    public static void readFromFilePages() throws Exception{
        BufferedReader reader = new BufferedReader(new FileReader("data.txt"));
        webPages.removeAll(webPages);
        String line;
        String[] subStr;

        while((line = reader.readLine())!=null){
            subStr = line.split("; ");
            webPages.add(new WebPage(subStr[0], subStr[1]));
        }
    }

    public static void readFromFileVisiting() throws Exception{
        BufferedReader reader = new BufferedReader(new FileReader("visiting.txt"));
        visitings.removeAll(visitings);
        String line;
        String[] subStr;

        while((line = reader.readLine())!=null){
            subStr = line.split("; ");
            visitings.add(new Visiting(subStr[0], subStr[1], LocalDate.parse(subStr[2]), Integer.parseInt(subStr[3]), Integer.parseInt( subStr[4])));
        }
    }

    public static void writeToFilePages() throws Exception{
        File file = new File("data.txt");
        file.createNewFile();
        FileWriter writer = new FileWriter(file);
        for(WebPage o : webPages){
            writer.write(o.getName()+ "; " + o.getURL() +"\n");
        }
        writer.flush();
        writer.close();
    }

    public static void writeToFileVisiting() throws Exception{
        File file = new File("visiting.txt");
        file.createNewFile();
        FileWriter writer = new FileWriter(file);
        for(Visiting o : visitings){
            writer.write(o.getName()+ "; " + o.getURL() + "; " + o.getDate() + "; " + o.getCountUniqHost() + "; " + o.getCountPages() +"\n");
        }
        writer.flush();
        writer.close();
    }

    public static  void addWebPage() throws Exception {
        Scanner s = new Scanner(System.in);

        System.out.println("Введіть назву сайта: "); String name = s.nextLine();
        System.out.println("Введіть URL"); String URL = s.nextLine();

        webPages.add(new WebPage(name, URL));

        writeToFilePages();
    }

    public static void addVisiting() throws Exception{
        Scanner s = new Scanner(System.in);

        System.out.println("Введіть назву: "); String name = s.nextLine();
        System.out.println("Введіть URL: "); String URL = s.nextLine();
        System.out.println("Введіть дату: "); LocalDate date = LocalDate.parse(s.nextLine());
        System.out.println("Введіть ксть унікальних хостів: "); int countUniqHost = Integer.parseInt(s.nextLine());
        System.out.println("Введіть ксть завантажених сторінок: "); int countPages = Integer.parseInt(s.nextLine());

        visitings.add(new Visiting(name, URL, date, countUniqHost, countPages));
        writeToFileVisiting();
    }

    public static float avarageCountHostPeriod(LocalDate date1, LocalDate date2) throws Exception{
        int sum = 0;
        for(Visiting o : visitings)
            if(o.getDate().compareTo(date1) > 0 && o.getDate().compareTo(date2) < 0)
                sum += o.getCountUniqHost();

        return (sum / visitings.size());
    }

    public static LocalDate mostPagesDay() throws Exception{
        int max = 0;
        LocalDate date = null;
        for(Visiting o : visitings)
            if(o.getCountPages() > max){
                max = o.getCountPages();
                date = o.getDate();
            }
        if(date == null)
            System.out.println("Не було відвідувань");
        return date;
    }

    public static int CheckIfMore(float n){
        int days = 0;
        for(Visiting o : visitings)
            if(o.getCountUniqHost() / o.getCountPages() > n)
                days++;
        return days;
    }

    public static void PrintData(){
        System.out.printf("%-20s", "Назва");
        System.out.printf("%-20s", "URL");
        System.out.printf("%-15s", "Дата");
        System.out.printf("%-15s", "Ксть хостів");
        System.out.printf("%-15s", "Ксть сторінок");
        System.out.println("");
        for(Visiting o : visitings)
            o.printData();
        System.out.println("");
    }

    public static void RemoveDataVisiting() throws Exception {
        Scanner s = new Scanner(System.in);
        System.out.println("Введіть url сайта для видалення: "); String URL = s.nextLine();

        visitings.removeIf(t -> t.getURL().equals(URL));
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

        for(Visiting o : visitings){
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
            readFromFilePages();
            readFromFileVisiting();
            System.out.println(" 1: Добавлення сайта, 2: Добавлення відвідування, 3: Вивести дані, 4: Редагувати відвідування, 5: Видалити 6: Завдання1, 7: Завдання2, 8: Завдання3");
            int n = s.nextInt();
            switch(n){
                case 1:
                    addWebPage();
                    break;
                case 2:
                    addVisiting();
                    break;
                case 3:
                    PrintData();
                    break;
                case 4:
                    EditDataVisiting();
                    break;
                case 5:
                    RemoveDataVisiting();
                    break;
                case 6:
                    System.out.println("Введіть початкову дату: ");
                    String str1 = s.next();
                    LocalDate date1 = LocalDate.parse(str1);
                    System.out.println("Введіть кінцеву дату: ");
                    String str2 = s.next();
                    LocalDate date2 = LocalDate.parse(str2);
                    System.out.println(avarageCountHostPeriod(date1, date2));
                    break;
                case 7:
                    System.out.println(mostPagesDay());
                    break;
                case 8:
                    float b = s.nextFloat();
                    System.out.println(CheckIfMore(b));
                    break;
                case 9:
                    loop = false;
                    break;
            }
        }
    }
}
