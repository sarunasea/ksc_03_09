package com.kcs.example.third;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Task5_2 {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter("example.txt"));
        bw.write("simple example write to file");
        bw.flush();
        bw.close();

    }
}
