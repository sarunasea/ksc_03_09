package com.kcs.example.third;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Task5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Task5 task5 = new Task5();
        System.out.println("Iveskite kilometrus: ");
        int km = task5.getValue(sc);
        System.out.println("Iveskite kuro sanaudas: ");
        int fuel = task5.getValue(sc);
        double sanaudos = task5.vid(km, fuel);
        System.out.println("Kuro sanaudos: " + sanaudos + " l/100km");
    }
    private double vid(int km, int fuel){
        return fuel*100/km;
    }
    private int getValue(Scanner sc){
        Integer value = null;
        while(value == null){
            try{
                value = sc.nextInt();
            }
            catch(InputMismatchException e){
                System.out.println("Neteisingai ivesta, pakartotkite");
                sc.nextLine();
            }
        }
        return value;
    }
}
