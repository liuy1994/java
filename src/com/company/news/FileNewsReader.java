package com.company.news;

public class FileNewsReader implements NewsReader {
    @Override
    public News readNews(String path) {
        System.out.println("Read news from file: " + path);
        return new News("file", "file content");
    }
}
