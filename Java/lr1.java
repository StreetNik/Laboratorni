package com.company;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("Введіть номер завдання: ");
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        switch(n){
            case 1:
                //zavdannia 1
                System.out.println("Завдання 1: ");
                System.out.println("Введіть спосіб вирішення завдання(1 або 2): ");
                Scanner in = new Scanner(System.in);

                break;
            case 2:
                //zavdannia 2
                System.out.println("Завдання 2: ");
                break;
            case 3:
                //zavdannia 3
                System.out.println("Завдання 3: ");
                break;
            case 4:
                //zavdannia 4
                System.out.println("Завдання 4: ");
                break;
            default:
                System.out.println("Номер завдання введено не вірно або такого завдання не існує");
                break;
        }
    }
}
