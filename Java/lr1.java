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
                System.out.println("Введіть спосіб вирішення завдання:\n1 - З використанням скороченої фоорми \n2 - з використанням повної форми");
                n = in.nextInt();
                int b, c;
                System.out.println("Введіть : b");
                b = in.nextInt();
                System.out.println("Введіть: c");
                c = in.nextInt();
                switch(n){
                    case 1:
                        if(c == 5){
                            System.out.println("a = " + (Math.sqrt(b) + 2 * Math.sqrt(c)));
                        }
                        if(c == 0)
                            System.out.println("a = " + (b / (c-6)));
                        if(c == -5)
                            System.out.println("a = " + (b + 3 * Math.pow(c, 3)));
                        break;
                    case 2:
                        if(c == 5)
                            System.out.println("a = " + (Math.sqrt(b) + 2 * Math.sqrt(c)));
                        else if (c == 0)
                            System.out.println("a = " + (b / (c-6)));
                        else if (c == -5)
                            System.out.println("a = " + (b + 3 * Math.pow(c, 3)));
                        else
                            System.out.println("Нема рішення");
                }

                break;
            case 2:
                //zavdannia 2
                System.out.println("Завдання 2: ");

                float a1, b1, c1;
                System.out.println("Введіть а");
                a1 = in.nextInt();
                System.out.println("Введіть b");
                b1 = in.nextInt();
                System.out.println("Введіть c");
                c1 = in.nextInt();

                if (a1<b1 && b1<c1){
                    a1 = a1*2;
                    b1 = b1*2;
                    c1 = c1*2;
                }else{
                    a1 = 1/a1;
                    b1 = 1/b1;
                    c1 = 1/c1;
                }
                System.out.println("a: " + a1);
                System.out.println("b: " + b1);
                System.out.println("c: " + c1);
                break;
            case 3:
                //zavdannia 3
                System.out.println("Завдання 3: ");
                System.out.println("Введіть прядковий номер дня тижня: ");
                n = in.nextInt();
                switch(n){
                    case 1:
                        System.out.println("Понеділок");
                        break;
                    case 2:
                        System.out.println("Вівторок");
                        break;
                    case 3:
                        System.out.println("Середа");
                        break;
                    case 4:
                        System.out.println("Четвер");
                        break;
                    case 5:
                        System.out.println("П'ятниця");
                        break;
                    case 6:
                        System.out.println("Субота");
                        break;
                    case 7:
                        System.out.println("Неділя");
                        break;
                    default:
                        System.out.println("Введено не коректний номер");
                }
                break;
            case 4:
                //zavdannia 4
                System.out.println("Завдання 4: ");
                try {
                    Scanner scanner = new Scanner(System.in);
                    int x, y;
                    System.out.println("Введіть х: ");
                    x = Integer.parseInt(scanner.next());
                    System.out.println("Введіть у: ");
                    y = Integer.parseInt(scanner.next());


                    double res = ((x * y + 2 * x - java.lang.Math.pow(y, x)) / (Math.sin(x) + x * y - 2 * x + y));
                    System.out.println("A = " + res);
                }catch(java.lang.NumberFormatException e){
                    System.out.println("Введено не число");
                }

                break;
            default:
                System.out.println("Номер завдання введено не вірно або такого завдання не існує");
                break;
        }
    }
}
