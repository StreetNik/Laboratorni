package com.company;

import java.util.Arrays;
import java.util.Scanner;

public class task2 {
    static public void ArrInput(){
        Scanner in = new Scanner(System.in);
        //zapovnennia masiva
        System.out.println("Введіть розмірність масиву: ");
        try{
        int n = in.nextInt();

        int[] arr = new int[n];
        System.out.println("Введіть значення масиву: ");
        for (int i = 0; i < n; i++)
            arr[i] = in.nextInt();
        if(Arrays.stream(arr).max().getAsInt() == Arrays.stream(arr).min().getAsInt())
            throw new Exception("Значення не можуть бути однаковими");
        Z1(arr);
        Main.menu();
        } catch (Exception e){
            System.out.println("Не вірно введені дані!!!" + e.getMessage());
            ArrInput();
        }
    }

    static public int[] Z1(int[] arr){
        int max = 0;
        int min = 0;

        for(int i = 0; i < arr.length; i++){
            if(arr[i] < arr[min])
                min = i;
            if(arr[i] > arr[max])
                max = i;
        }

        int[] ints = new int[]{min, max};
        System.out.println("Min: " + ints[0] + "; Max: " + ints[1]);

        return ints;
    }
}
