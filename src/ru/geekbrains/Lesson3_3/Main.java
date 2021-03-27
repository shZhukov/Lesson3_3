package ru.geekbrains.Lesson3_3;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here
        try {
            // Задание 1
            readFile("src/datafile1.txt");
            
            //Задание 2
            // stickFiles();

            // Задание 3
            // readText();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void readFile(String fileName) throws IOException{
        BufferedInputStream inStr = new BufferedInputStream(new FileInputStream(fileName));
        ByteArrayOutputStream outStr = new ByteArrayOutputStream();
        int a;
        byte[] bArry;

        while ((int) inStr.read() != -1){
            a = inStr.read();
            outStr.write(a);
        }
        bArry = outStr.toByteArray();
        System.out.println(Arrays.toString(bArry));

        inStr.close();
        outStr.close();
    }

    public static void stickFiles() throws IOException{

        BufferedInputStream inStr;
        BufferedOutputStream outStr;
        int a;


        ArrayList<InputStream> al = new ArrayList<>();
        al.add(new FileInputStream("src/1.txt"));
        al.add(new FileInputStream("src/2.txt"));
        al.add(new FileInputStream("src/3.txt"));
        al.add(new FileInputStream("src/4.txt"));
        al.add(new FileInputStream("src/5.txt"));

        inStr = new BufferedInputStream(new SequenceInputStream(Collections.enumeration(al)));
        outStr = new BufferedOutputStream(new FileOutputStream("src/stickOut.txt"));

        while ((int) inStr.read() != -1){
            a = inStr.read();
            outStr.write(a);

        }
        inStr.close();
        outStr.close();
    }

    public static void readText() throws IOException{
        long startTime = System.currentTimeMillis();
        int pageSize = 1800;
        RandomAccessFile fileText = new RandomAccessFile("src/datafile2.txt", "r");
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите номер страницы ");
        int page = sc.nextInt() -1;
        fileText.seek( page * pageSize);
        byte[] arrByte = new byte[pageSize];
        fileText.read(arrByte);
        System.out.println(new String(arrByte));
        fileText.close();
        System.out.println("------------------------------");
        System.out.println(System.currentTimeMillis() - startTime);

    }
}
