package com.kcs.example.third;

import java.lang.reflect.GenericDeclaration;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Task6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int end = -1;
        while(end != 0) {
            try {
                System.out.println("Iveskite formule:");
                String input = getValue(sc);
                String[] elements = input.split(" ");
                double first = Double.parseDouble(elements[0]);
                char symbol = elements[1].charAt(0);
                double second = Double.parseDouble(elements[2]);
                switch (symbol) {
                    case '+':
                        plus(first, second);
                        break;
                    case '-':
                        minus(first, second);
                        break;
                    case '/':
                        division(first, second);
                        break;
                    case '*':
                        multi(first, second);
                        break;
                    case '^':
                        degree(first, second);
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Tokio veiksmo nera galimybes atlikti");
                getValue(sc);
            }
            catch (NumberFormatException f){
                System.out.println("Neteisingas ivedimo formatas");
                getValue(sc);
            }
            catch(ArrayIndexOutOfBoundsException z){
                System.out.println("Per mazai f-jos argumentu");
                getValue(sc);
            }
            System.out.println("Noredami baigti, spauskite 0");
        }
    }



    private static void degree(double a, double b) {
        System.out.println("Ats: " + Math.pow(a,b));
    }

    private static void minus(double a, double b) {
        System.out.println("Ats: " + (a-b));
    }

    private static void multi(double a, double b) {
        System.out.println("Ats: " + (a*b));
    }

    private static void division(double a, double b) {
        try{
        System.out.println("Ats: " + (a/b));
        }
        catch(NullPointerException n){
            System.out.println("Dalyba iš nulio negalima");
        }

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
    private static void plus(double a, double b){
        System.out.println("Ats: " + (a+b));
    }

}
