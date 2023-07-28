package com.company.news;

public class UrlNewsReader implements NewsReader {
    @Override
    public News readNews(String path) {
        System.out.println("Read news from url: " + path);
        return new News("url", "url content");
    }}
