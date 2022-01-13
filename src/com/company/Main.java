package com.company;

import com.company.Human;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class Main {

    public static void main(String[] args) throws IOException {



        InputStreamReader reader1 =  new InputStreamReader(System.in);

        char[] buffer = new char[20];
        int length = reader1.read(buffer);

        System.out.println(length);
        System.out.println(buffer);

        // 从一个文件读取内容，输出到另一个文件

        FileInputStream input = new FileInputStream("res/input.txt");
        FileOutputStream output = new FileOutputStream("res/output.txt");

        InputStreamReader reader = new InputStreamReader(input, StandardCharsets.UTF_8);
        OutputStreamWriter writer = new OutputStreamWriter(output, StandardCharsets.UTF_8);

        BufferedReader bufferedReader = new BufferedReader(reader);
        PrintWriter printer = new PrintWriter(writer);

//        bufferredReader.readLine();

//        String context = new String();
//        for (String line = bufferedReader.readLine(); line != null; line = bufferedReader.readLine()) {
//            // 处理这一行
//            context = context + line;
//
//        }

        String context = "";
        String line = null;
        while ((line = bufferedReader.readLine()) != null) {
            context += line + "\n";
        }

        reader.close();
        input.close();
        System.out.println(context);
        printer.print(context);
        printer.close();
        output.close();
        System.out.println(context);
    }
}
