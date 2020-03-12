package com.kcs.example.third;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Set;

public class Task5_1 {
    public static void main(String[] args) {
        try (BufferedReader bf = new BufferedReader(new FileReader("cars.txt"))){
            String line;
            String carName = null;
            double bestEconomy = 0.0;
            while((line = bf.readLine()) != null){
                Task5 task5 = new Task5();
                String[] elements = line.split(" ");
                double ats = task5.vid(Integer.parseInt(elements[1]), Integer.parseInt(elements[2]));
                if(bestEconomy == 0 || bestEconomy > ats){
                    bestEconomy = ats;
                    carName = elements[0];
                }

                /*System.out.println(elements[0]);
                System.out.println(elements[1]);
                System.out.println(elements[2]);
                System.out.println(line);*/
            }
            System.out.println("Optimaliausias automobilis: " + carName + "Sanaudos: " + bestEconomy);
            bf.readLine();
        } catch (IOException e) {
            System.out.println("Nepavyko nuskaityti failo");
        }

    }
}
