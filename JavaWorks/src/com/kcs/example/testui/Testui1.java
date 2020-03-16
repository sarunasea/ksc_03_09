package com.kcs.example.testui;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Testui1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int end = -1;
        while(end != 0) {
            try {
                System.out.println("Iveskite formule:");
                String input = getValue(sc);
                String[] elements = input.split(" ");
                if(elements.length == 1){
                    end = Integer.parseInt(input);
                    if(end == 0){
                        System.exit(0);
                    }
                }

                double first = Double.parseDouble(elements[0]);
                char symbol = elements[1].charAt(0);
                double second = Double.parseDouble(elements[2]);
                if(elements.length > 3){
                    System.out.println("Per daug f-jos argumentų, veiksmai atliekami tik su pirmais 2 skaičiais".toUpperCase());
                }
                if(second == 0.0){
                    System.out.println("Pakartokite įvedima (antras skaičius 0)");
                    continue;
                }
                switch (symbol) {
                    case '+':
                        double sum = plus(first, second);
                        System.out.println("Ats: " + sum);
                        break;
                    case '-':
                        double dec = minus(first, second);
                        System.out.println("Ats: " + dec);
                        break;
                    default:
                        System.out.println("Galimybės atlikti nurodytą veiksmą nenumatyta");
                }
            } catch (InputMismatchException e) {
                System.out.println("Tokio veiksmo nera galimybes atlikti");
                continue;
            }
            catch (NumberFormatException f){
                System.out.println("Neteisingas ivedimo formatas");
                continue;
            }
            catch(ArrayIndexOutOfBoundsException z){
                System.out.println("Per mazai f-jos argumentu");
                continue;
            }
            System.out.println("Noredami baigti, spauskite 0");
        }
    }

    private static double minus(double a, double b) {
        return a-b;
    }

    private static String getValue(Scanner sc){
        String value = null;
        while(value == null){
            try{
                value = sc.nextLine();
            }
            catch(InputMismatchException e){
                System.out.println("Nieko neivesta");
            }
        }
        return value;
    }
    private static double plus(double a, double b){
        return a+b;
    }

}
