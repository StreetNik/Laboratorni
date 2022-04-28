package com.company;

import java.util.Scanner;
import java.util.Random;

public class Main {

    public static void menu(){
        Scanner in = new Scanner(System.in);
        System.out.println("Введіть номер завдання: ");
        int zavdannia = in.nextInt();
        switch(zavdannia){
            case 1:
                task1.ArrInput();
                break;
            case 2:
                task2.ArrInput();
                break;
            case 10:
                break;
            default:
                System.out.println("Такого завдання не існує, спробуйте знову");
                menu();
                break;
        }
    }

    public static void main(String[] args) {
        menu();
    }
}
