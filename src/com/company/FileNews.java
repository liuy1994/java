package com.company;

import java.io.*;

public class FileNews extends News {
    public FileNews(String title, String content) {
        super(title, content);
    }

    public void readFromFile(String fileUrl) throws IOException {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(new File(fileUrl)));
            String title = reader.readLine();
            setTitle(title);
            reader.readLine();
            String content = reader.readLine();
            setContent(content);
            reader.close();
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
