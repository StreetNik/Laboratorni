package com.company;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        boolean loop = true;
        Scanner scanner = new Scanner(System.in);
        while (loop){
            System.out.print("Виберіть завдання [1],[2] -> ");
            String choice = scanner.next();
            switch (choice){
                case "1":
                    task1();
                    break;
                case "2":
                    task2();
                    break;
                case "3":
                    task3();
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
    public static void task1(){
        int symbols = 0;
        System.out.print("Введіть будь яку фразу -> ");
        String input = new Scanner(System.in).nextLine();
        System.out.println("-------------------------");
        System.out.println("Слово: "+ input);
        char[] arr = input.toCharArray();
        for(char s:arr)
            if(!Character.isLetter(s) && s != ' ')
                symbols++;
        String[] ary = input.split(" ");
        ArrayList<String> array = new ArrayList<>();

        for (String s:ary) {
            int length = s.toCharArray().length;
            if(!Character.isLetter(s.toCharArray()[s.toCharArray().length - 1]))
                length--;
            if(length % 2 == 0){
                array.add(s);
            }
        }
        System.out.print("Новий масив: ");
        for (String s:array) {
            System.out.print(s+" ");
        }
        System.out.print("\n");

        System.out.println("Кількість розділових знаків у рядку: "+ symbols);
    }
    public static void task2() {
            int count = 0;
            Scanner scanner = new Scanner(System.in);
            System.out.println("Введіть діапазон: ");
            int a = Integer.parseInt(scanner.next());
            int b = Integer.parseInt(scanner.next());
            File file = new File("222.txt");
        try(BufferedReader br = new BufferedReader(new FileReader(file))) {
            String c;  // посимвольне читання
            while((c = br.readLine()) != null) {
                String[] ary = c.split(" ");
                for(String s:ary){
                    int v = Integer.parseInt(s);
                    if(v >= a && v <= b)
                        count++;
                }
            }}catch(IOException ex) {
            System.out.println(ex.getMessage());
        }

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(file, true))){
            String message = String.format("%d", count);
            bw.append(" " + message);
        }
        catch(IOException ex) {
            System.out.println (ex.getMessage());
        }
        System.out.println(count);
    }

    public static void task3(){
        File file = new File("input.txt");
        try(BufferedReader br = new BufferedReader(new FileReader(file))) {
            String c;
            char[] bykvi = {'b', 'B', 'C', 'c', 'D', 'd', 'F', 'f', 'G', 'g', 'H', 'h', 'J', 'j',
                            'K', 'k', 'L', 'l', 'M', 'm', 'N', 'n', 'P', 'p', 'Q', 'q', 'R', 'r',
                            'S', 's', 'T', 't', 'V', 'v', 'W', 'w', 'X', 'x', 'Y', 'y', 'Z', 'z'};
            while((c = br.readLine()) != null) {
                String[] ary = c.split(" ");
                for(String s:ary)
                    for(int i =0; i < 42; i++)
                        if(s.toCharArray()[0] == bykvi[i])
                            System.out.print(s + " ");
            }
        }catch(IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}

