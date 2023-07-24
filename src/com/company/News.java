package com.company;

public class News {
    private String title;
    private String content;
    public News(String title, String content) {
        this.title = title;
        this.content = content;
    }

    public String getTitle() {
        return this.title;
    }

    public String getContent() {
        return this.content;
    }

    public void display() {
        System.out.println("Title: " + this.getTitle());
        System.out.println("Content: " + this.getContent());
    }
}
