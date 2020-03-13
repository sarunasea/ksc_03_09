package com.kcs.example.fourth;

import java.io.*;
import java.util.*;

public class TaskList1 {
    private static final String TARPAS = "tarpas";
    private static final String EMPTY = " ";
    public static void main(String[] args) {

        Map<String, String> codes = codeRead(true);
        StringBuilder sb = new StringBuilder();
        for(String item : readLetter()){
            String translation = codes.get(item);
            if(translation.equals(TARPAS)){
                translation = EMPTY;
            }
            sb.append(translation);
        }
        System.out.println("Isverstas laiskas " + sb.toString());
        encrypt();
    }

    private static void encrypt(){
        Map<String, String> codes = codeRead(false);
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        String line = sc.nextLine();
        for(int i = 0; i < line.length(); i++){
            String item = String.valueOf(line.charAt(i));
            if(EMPTY.equals(item)){
                item = TARPAS;
            }
            String encrypt = codes.get(item);
            sb.append(encrypt).append(" ");
        }
        String result = sb.toString().trim();
        writeToFile(result);
    }
    private static void writeToFile(String text){
        try{
            BufferedWriter bw = new BufferedWriter(new FileWriter("encrypted.txt"));
            bw.write(text);
            bw.flush();
            bw.close();
        }
        catch(IOException e){
            System.out.println("Cannot write to file");
        }
    }
    private static List<String> readLetter(){
        List<String> letters = new ArrayList<>();
        try{
        BufferedReader bf = new BufferedReader(new FileReader("laiskas.txt"));
        String line;
        while((line = bf.readLine()) != null){
            letters.addAll(Arrays.asList(line.split(EMPTY)));
        }
    }
        catch(IOException e){
            System.out.println("cannot read letter file");
        }
        return letters;
    }
    private static Map<String, String> codeRead(boolean isEncodeKey){
        Map<String, String> codes = new HashMap<>();
        try{
            BufferedReader bf = new BufferedReader(new FileReader("codes.txt"));
            String line;
            while((line = bf.readLine()) != null){
                String[] items = line.split(EMPTY);
                if(items.length == 2){
                    codes.put(isEncodeKey?items[0]:items[1], isEncodeKey?items[1]: items[0]);
                }

            }
        }
        catch(IOException e){
            System.out.println("cannot read code file");
        }
        return codes;
    }
}
