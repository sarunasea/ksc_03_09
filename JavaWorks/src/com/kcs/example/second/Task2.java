package com.kcs.example.second;

import java.util.Scanner;

public class Task2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String text = sc.nextLine().replaceAll(" ", "");
        boolean isPalindrome = true;
        for(int i=0; i < text.length(); i++){
            char first = text.charAt(i);
            char last = text.charAt(text.length() - i - 1);
            if(first != last){
                isPalindrome = false;
                break;
            }
        }
        if(isPalindrome == true){
            System.out.println("palindromas");
        }
        else{
            System.out.println("nepolindromas");
        }
    }
}
