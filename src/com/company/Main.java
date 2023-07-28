package com.company;
import com.company.animal.*;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
//        // 继承
//        News news = new News("title", "content");
////        news.read("res/input.txt");
//        System.out.println(news.display());
////        news.write("res/output.txt");
////        news.write("res/output2.txt");
//        FileNews fileNews = new FileNews("fileTitle", "fileContent");
//        System.out.println(fileNews.display());
        Human human = new Human("human");
        human.say();

        Dog dog = new Dog("dog");
        dog.say();
    }
}


