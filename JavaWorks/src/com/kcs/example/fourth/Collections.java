package com.kcs.example.fourth;

import java.util.*;

public class Collections {
    public Collections(){
        this(3);
    }
    public Collections(int sk){

    }
    public static void main(String[] args) {

        List <String> names = new ArrayList<>();
        names.add("andrius");
        System.out.println("Ilgis: " + names.size() + " " + names.get(0));
        List <Integer> numbers = List.of(1, 4, 5, 6);
        System.out.println(numbers.contains(1));

        for(Integer number: numbers){
            System.out.println(number);
        }

        numbers.forEach(System.out::println);
        Set<Integer> numbs = new TreeSet<>();
        numbs.add(4);
        numbs.add(3);
        numbs.add(2);
        numbs.add(4);
        numbs.forEach(System.out::println);

        Map<Integer, String> cars = new HashMap<>();
        cars.put(2, "Audi");
        cars.put(3, "BMW");
        cars.put(1, "Volvo");
        cars.forEach((integer, s) -> System.out.println("key " + integer + "value " + s));

        for(Integer key : cars.keySet()){
            System.out.println(key);
        }
    }


}
