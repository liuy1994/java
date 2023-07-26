package com.company;
import java.nio.charset.*;
import java.util.*;
import java.io.*;


public class Main {
    public static void main(String[] args) throws IOException {
        FileInputStream input = new FileInputStream("res/input.txt");
        FileOutputStream output = new FileOutputStream("res/output.txt");

        InputStreamReader reader = new InputStreamReader(input, StandardCharsets.UTF_8);
        OutputStreamWriter writer = new OutputStreamWriter(output, StandardCharsets.UTF_8);

        BufferedReader buffer = new BufferedReader(reader);
        PrintWriter print = new PrintWriter(writer);

        String content = "";
        String line = buffer.readLine();
        while (line != null) {
            content += line + "\n";
            line = buffer.readLine();
        }
        buffer.close();
        reader.close();
        input.close();
        System.out.println(content);
        print.print(content);
        print.close();
        writer.close();
        output.close();
    }
}


