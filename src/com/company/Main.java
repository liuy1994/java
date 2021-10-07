package com.company;

import com.company.Human;

import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {

        PrintStream output = System.out;
        output.println("hello word");

        InputStream input = System.in;

        InputStreamReader reader =  new InputStreamReader(input);

        char[] buffer = new char[20];
        int length = reader.read(buffer);

        output.println(length);
    }
}
