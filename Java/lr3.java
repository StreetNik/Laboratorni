package com.company;
import java.util.Arrays;
import java.util.Random;
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
            case 10:
                break;
            default:
                System.out.println("Такого завдання не існує, спробуйте знову");
                menu();
                break;
        }
    }

    public static void zavdannia1(){
            Scanner in = new Scanner(System.in);
            int[] arr = new int[10];
            int n = arr.length;
            for(int i = 0; i < arr.length; i++){
                arr[i] = new Random().nextInt(21) - 10;
            }
            for(int i = 0; i < 10; i++)
                System.out.println(arr[i]);
            try{
                System.out.println("Введіть межі пошуку");
                int x = in.nextInt();
                int b = in.nextInt();
                if(x > b || b > n || x > n)
                    throw new Exception("Значення введено не коректно");
                int n1 = 0;
                for(int i = x; i < b; i++)
                    if(arr[i] < 0)
                        n1++;
                System.out.println("Кількість відємних чисел: " + n1);
            }catch(Exception ex){
                System.out.println(ex.getMessage());
            }
            menu();
        }

    public static void zavdannia2(){
        Scanner in = new Scanner(System.in);
        System.out.println("Введіть спосіб вирішення: ");
        int n = in.nextInt();
        int vid = 0;
        int res = 0;
        switch(n){
            case 1:
                System.out.println("Введіть розмірність масива: ");
                int n1 = in.nextInt();
                int[] arr = new int[n1];
                System.out.println("Введіть масив: ");
                for (int i = 0; i < n1; i++)
                    arr[i] = in.nextInt();

               for (int i = 0; i < arr.length; i++){
                   if(arr[i] < 0)
                       vid++;
                   if(arr[i] == Arrays.stream(arr).min().getAsInt()){
                       for(int j = i+1; j < arr.length; j++){
                           res += arr[j];
                       }
                   }
                }
               System.out.println("Кількість відємниї чисел: " + vid);
               System.out.println("Сума чисел після мінімального : " + res);

                break;
            case 2:
                int[] array = new int[10];
                for(int i = 0; i < 10; i++){
                    array[i] = new Random().nextInt(201) - 100;
                    System.out.println(array[i] + " ");
                }

                for (int i = 0; i < array.length; i++){
                    if(array[i] < 0)
                        vid++;
                    if(array[i] == Arrays.stream(array).min().getAsInt()){
                        for(int j = i+1; j < array.length; j++){
                            res += array[j];
                        }
                    }
                }
                System.out.println("Кількість відємниї чисел: " + vid);
                System.out.println("Сума чисел після мінімального : " + res);

                break;
            default:
                System.out.println("Спробуйте знову!");
                zavdannia2();
        }
        menu();
    }
    public static void main(String[] args) {
	    menu();
    }
}
