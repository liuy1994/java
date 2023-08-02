package demo.view;

import demo.model.News;

import java.util.ArrayList;

public class NewsListViewer {

    private ArrayList<News> newsList;

    public NewsListViewer(ArrayList<News> newsList) {
        this.newsList = newsList;
    }

    public void display() {
        for (News news : newsList) {
            System.out.println("==============");
            System.out.println("Title: " + news.getTittle());
            System.out.println("Content: " + news.getContent());
            System.out.println("Related: \n" + news.getRelated());
        }
    }
}
