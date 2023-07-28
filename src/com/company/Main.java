package com.company;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        News news = new News("title", "content");
//        news.read("res/input.txt");
        System.out.println(news.display());
//        news.write("res/output.txt");
//        news.write("res/output2.txt");
        FileNews fileNews = new FileNews("fileTitle", "fileContent");
        System.out.println(fileNews.display());
    }
}


