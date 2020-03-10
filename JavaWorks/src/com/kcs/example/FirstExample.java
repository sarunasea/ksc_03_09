package com.kcs.example;

public class FirstExample {
    public static void main(String[] args) {
        System.out.println("Labas");
        FirstExample firstExample = new FirstExample();
        System.out.println(firstExample.sum(10, 10));
    }
//ab
    private int sum(int a, int b) {
        return a + b;
    }

}
