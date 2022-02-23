package com.company;
import java.util.Scanner;

public class Main {
    public static void menu(){
        Scanner in = new Scanner(System.in);
        System.out.println("Введіть номер завдання: ");
        int zavdannia = in.nextInt();
        switch(zavdannia){
            case 1:
                zavdannia1();
                break;
            case 2:
                zavdannia2();
                break;
            case 3:
                zavdannia3();
                break;
            case 4:
                zavdannia4();
                break;
            case 10:
                break;
            default:
                System.out.println("Такого завдання не існує, спробуйте знову");
                menu();
                break;
        }
    }

    public static double log2(double N)
    {
        double result = (Math.log(N) / Math.log(2));

        return result;
    }

    public static void zavdannia1(){
        Scanner in = new Scanner(System.in);
        int x, y, z;
        double t;
        boolean error = true;
        do {
            System.out.println("Введіть х:");
            x = in.nextInt();
            System.out.println("Введіть y:");
            y = in.nextInt();
            System.out.println("Введіть z:");
            z = in.nextInt();
            try
            {
                double r1 = 1+x;
                if(r1 == 0) throw new Exception("Ділення на 0");

                double r2 = (1-y)/(r1)+z;
                if(r2 < 0) throw new Exception("Логарифм меньше 0");

                double res = log2(r2);
                System.out.println("Результат: "+res);
                error = false;

            }
            catch (Exception ex)
            {
                System.out.println(ex.getMessage());
            }
        } while(error);
        menu();
    }

    public static void zavdannia2(){
        Scanner in = new Scanner(System.in);
        int sum = 0;
        for(int i = 1; i <= 100; i++){
            if(i % 11 == 0)
                sum += i;
        }
        int res = sum * sum;
        System.out.println("Результат (for): " + res);

        sum = 0;
        int i = 1;
        while(i<=100){
            if(i % 11 == 0)
                sum += i;
            i++;
        }
        res = sum * sum;
        System.out.println("Результат (while): " + res);
        System.out.println("Результат (do while): " + res);
        sum = 0;
        i = 1;
        do{
            if(i % 11 == 0)
                sum += i;
            i++;
        } while(i<=100);
        res = sum * sum;


        menu();
    }

    public static void zavdannia3(){
        Scanner in = new Scanner(System.in);
        float sum = 0;
        //я знаю що таке Е але що таке П хз))  я вроді поняв

        for (int i = 1; i <= 25; i++)
        {
            for (int j = 1; j <= i; j++)
            {
                sum += (j+i) / 2;
            }
        }
        System.out.println("Результат: " + sum);

        menu();
    }

    public static void zavdannia4(){

        double a = -(Math.PI / 2);
        double b = (Math.PI / 2);
        for (double i = a; i < b; i+= Math.PI / 20){
            try{
            if(i == 0)
                throw new Exception("Х наближений до нескінечності");
            System.out.println("y = " + 1.0 / (Math.tan(i)) + " x = " + i);
                }
            catch (Exception ex)
            {
                System.out.println(ex.getMessage());
            }
                }
        System.out.println("Для виходу введіть 10");
        menu();
    }

    public static void main(String[] args) {
        menu();
    }
}
