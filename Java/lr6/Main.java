package com.company;
import java.util.*;
import java.io.*;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static ArrayList<Music> musics = new ArrayList<>();

    public static void readFromFile() throws Exception{
        BufferedReader reader = new BufferedReader(new FileReader("/Users/stanislavnikulica/Documents/GitHub/Laboratorni/Java/lr6/src/data.txt"));
        musics.removeAll(musics);
        String line;
        String[] subStr;

        while((line = reader.readLine()) != null){
            subStr = line.split(" ");
            musics.add(new Music(subStr[0], subStr[1], subStr[2], Integer.parseInt(subStr[3]), Float.parseFloat(subStr[4])));
        }
    }

    public static void writeToFile() throws IOException {
        File file = new File("/Users/stanislavnikulica/Documents/GitHub/Laboratorni/Java/lr6/src/data.txt");
        file.createNewFile();
        FileWriter writer = new FileWriter(file);
        for(Music o : musics){
            writer.write(o.getName() + " " + o.getAuthor() + " " + o.getAlbum() + " " + o.getYear()+ " " + o.getDuration() + "\n");
        }
        writer.flush();
        writer.close();
    }

    public static void Sort(){
        Collections.sort(musics, new Comparator<Music>() {
            @Override
            public int compare(Music o1, Music o2) {
                return o1.getName().compareTo(o2.getName());
            }
        });
    }

    public static void addMusic() throws Exception{
        Scanner s = new Scanner(System.in);

        System.out.println("Введіть назву пісні: "); String name = s.nextLine().replace(' ', '_');
        System.out.println("Введіть виконавця: "); String author = s.nextLine().replace(' ', '_');
        System.out.println("Введіть назву альбома: "); String album = s.nextLine().replace(' ', '_');
        System.out.println("Введіть рік вихода: "); int year = s.nextInt();
        System.out.println("Введіть тривалість: "); float duration = s.nextFloat();

        musics.add(new Music(name, author, album, year, duration));

        writeToFile();

    }

    public static  void showData(){
        for(Music o : musics){
            System.out.println("Name: " + o.getName().replace('_', ' ') + "; Author: " + o.getAuthor().replace('_', ' ') + "; Album: " + o.getAlbum().replace('_', ' ') + "; Year: " + o.getYear()+ "; Duration: " + o.getDuration() + ";\n");
        }
    }

    public static void sortData() throws Exception {
        readFromFile();

        Collections.sort(musics, new Comparator<Music>(){
            @Override
            public int compare(Music o1, Music o2){
                if(o1.getName() != o2.getName())
                    return o1.getName().compareTo(o2.getName());
                else
                    return o1.getAlbum().compareTo(o2.getAlbum());
            }
        });
        writeToFile();
    }

    public static void removeData() throws IOException {
        System.out.println("Введіть назву пісні яку хочете вилучити: ");
        Scanner s = new Scanner(System.in);
        String str = s.nextLine().replace(' ', '_');

        musics.removeIf(t -> t.getName().equals(str));
        showData();
        writeToFile();
    }

    public static  void searchMusic(){
        System.out.println("Введіть імя автора композиції якого шукаєте: ");
        Scanner s = new Scanner(System.in);
        String str = s.nextLine().replace('_', ' ');

        for(Music o : musics)
            if(o.getAuthor().equals(str))
                System.out.println(o.toString().replace('_', ' '));

    }

    public static void editMusic() throws IOException {
        System.out.println("Введіть назву композиції дані про яку хочете змінити: ");
        Scanner s = new Scanner(System.in);
        String str = s.nextLine().replace(' ', '_');

        System.out.println("Введіть назву композиції: ");
        String name = s.nextLine().replace(' ', '_');
        System.out.println("Введіть виконавця композиції: ");
        String author = s.nextLine().replace(' ', '_');
        System.out.println("Введіть назву альбома: ");
        String album = s.nextLine().replace(' ', '_');
        System.out.println("Введіть рік виходу: ");
        int year = Integer.parseInt(s.nextLine());
        System.out.println("Введіть тривалість композиції: ");
        float duration = Float.parseFloat(s.nextLine());

        boolean found = false;

        for(Music o : musics)
            if(o.getName().equals(str)){
                found = true;
                o.setValues(name, author, album, year, duration);
            }
        if(!found){
            System.out.println("Композицію не знайдено");
            editMusic();
        }else{
        writeToFile();}
    }

    public static void menu() throws Exception {
        System.out.println("Виберіть дію: (1-add music; 2 - show data; 3 - sort data; 4 -delete music; 5 search music; 6 - edit music)");
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        switch (n){
            case 1:
                addMusic();
                menu();
                break;
            case 2:
                showData();
                menu();
                break;
            case 3:
                sortData();
                menu();
                break;
            case 4:
                removeData();
                menu();
                break;
            case 5:
                searchMusic();
                menu();
                break;
            case 6:
                editMusic();
                menu();
                break;
        }
    }

    public static void main(String[] args) throws Exception{
        readFromFile();
        menu();
    }
}
