package com.kcs.example.second;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Task3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Task3 task3 = new Task3();
        int select = -1;
        while (select != 0) {
        System.out.println("Pasirinkite figūrą: ");
        System.out.println("1. Statusis trikampis\n 2. Stačiakampis\n 3. Kvadratas\n 4. Apskritimas\n 0. Pabaiga");
        select = getCorrectValue(sc);
        switch (select) {
            case 1:
                System.out.println("Įveskite trikampio statinių ilgius: ");
                triangle(sc);
                break;
            case 2:
                System.out.println("Įveskite stačiakampio kraštinių ilgius: ");
                stac(sc);
                break;
            case 3:
                System.out.println("Įveskite kvadrato kraštinių ilgius: ");
                kvad(sc);
                break;
            case 4:
                System.out.println("Įveskite apskritimo spindulį: ");
                circ(sc);
                break;
        }
    }
}

    private static void triangle(Scanner sc) {
        int a = getCorrectValue(sc);
        int b = getCorrectValue(sc);
        System.out.println("Trikampio plotas: " + (a * b) / 2);
    }

    private static void stac(Scanner sc) {
        int a = getCorrectValue(sc);
        int b = getCorrectValue(sc);
        System.out.println("Stačikampio plotas " + a * b);
    }

    private static void kvad(Scanner sc) {
        int a = getCorrectValue(sc);
        System.out.println("Kvadrato plotas " + a * a);
    }
    private static void circ(Scanner sc){
        int a = getCorrectValue(sc);
        System.out.println("Apskritimo plotas: " + 3.14*a*a);
    }

    private static int getCorrectValue(Scanner sc) {
        while (true) {
            try {
                int result = sc.nextInt();
                return result;
            } catch (InputMismatchException e) {
                System.out.println("blogai įvestas skaičius, pakartokite");
                sc.nextLine();
            }
        }
    }
}
