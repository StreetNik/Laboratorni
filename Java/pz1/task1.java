package com.company;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class task1 {

    public static void ArrInput() {
        Scanner in = new Scanner(System.in);
        //zapovnennia masiva
        try{
        System.out.println("Введіть 10 чисел: ");
        int[] arr = new int[10];
        for (int i = 0; i < 10; ++i)
            arr[i] = in.nextInt();
        if(Arrays.stream(arr).max().getAsInt() == Arrays.stream(arr).min().getAsInt())
            throw new Exception("Значення не можуть бути однаковими");
        Z1(arr);
        Z2(arr);
        Main.menu();
        }
        catch(Exception e){
            System.out.println("Не вірно введені значення!!!" + e.getMessage());
            ArrInput();
        }
    }

        //Z1.1
    public static int Z1(int[] arr) {
        System.out.println("Завдання 1.1");System.out.println("");
        int dob = 1;
        for (int j = 0; j < 10; j++) {
            if (arr[j] % 2 == 0)
                dob = dob * arr[j];
        }
        System.out.println("Добуток: " + dob);System.out.println("");
        System.out.println("Кінець завдання 1.1");System.out.println("");
        return dob;
    }

    //Z1.2
    public static int Z2(int[] arr) {
        System.out.println("Завдання 1.2");
        int max = arr[0];
        int num = 0;
        int sum = 0;

        for (int i = 0; i < 10; i++){
            System.out.println(arr[i] + " ");
            if(Math.abs(arr[i]) > max){

                max = Math.abs(arr[i]);
                num = i;
            }
        }
        for (int k = num; k > 0; k--)
            sum = sum + arr[k];
        System.out.println("Сума: " + sum);System.out.println("");
        System.out.println("Кінець завдання 1.2");System.out.println("");
        return sum;
    }
}
