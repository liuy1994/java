package com.company.news;

public class News {
    public String title;
    public String content;

    public News(String title, String content) {
        this.title = title;
        this.content = content;
    }

    public void display() {
        System.out.println("Title: " + title + "\nContent: " + content);
    }

}
