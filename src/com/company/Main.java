package com.company;
import java.util.*;
import java.io.*;


public class Main {
    public static void main(String[] args) throws IOException {
        InputStreamReader reader = new InputStreamReader(System.in);
        char[] buffer = new char[20];
        int length = reader.read(buffer);
        System.out.println(length);
    }
}


