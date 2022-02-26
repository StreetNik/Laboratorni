package com.company;
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
        int n = 0; int m = 0;
        System.out.println("Введіть розмірність масива: ");
        try {
            n = in.nextInt();
            m = in.nextInt();
            if(n <= 0 || m <= 0)
                throw new Exception("Значення введено не коректно!");
        }catch(Exception ex){
            System.out.println(ex.getMessage());
            zavdannia1();
        }
        int[][] matrix = new int[n][m];
        for (int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                matrix[i][j] = new Random().nextInt(10);
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println(" ");
        }

        int min = 0; int max = 0; int min1 = 0; int max1 = 1;

        for(int i = 0; i < n; i++)
            for(int j = 0; j < m; j++){
                if (matrix[i][j] > max) {
                    max = matrix[i][j];
                    max1 = 0;
                }
                if (matrix[i][j] < min) {
                    min = matrix[i][j];
                    min1 = 0;
                }
                if (min == matrix[i][j])
                    min1++;
                if (max == matrix[i][j])
                    max1++;
            }

        System.out.println("Max n = " + max1 + "; Min n = " + min1 + ";");
        menu();
    }

    public static void zavdannia2(){
        Scanner in = new Scanner(System.in);
        int n = 0; int m = 0;
        System.out.println("Введіть розмірність масива: ");
        try{
            n = in.nextInt();
            m = in.nextInt();
            if (m <= 0 || n <= 0)
                throw new Exception("Значення введено некоректно!");
        }catch(Exception ex){
            System.out.println(ex.getMessage());
            zavdannia2();
        }
        int[][] matrix = new int[n][m];
        for (int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                matrix[i][j] = new Random().nextInt(10);
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println(" ");
        }

        System.out.println("Введіть шукане число: ");
        int k = in.nextInt();
        int n1 = 0;
        for(int i = 0; i < n; i++)
            for(int j = 0; j < m; j++)
                if(matrix[i][j] == k)
                    n1++;
        System.out.println("Кількість повторень числа " + k + ": " + n1);
        menu();
    }
    public static void main(String[] args) {
        menu();
    }
}
