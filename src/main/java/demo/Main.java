package demo;

import demo.model.News;
import demo.model.NewsFactory;
import demo.view.NewsListViewer;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args)  {
        System.out.println("Hello world!");
        String resource_path = Main.class.getClassLoader().getResource("read_hub").getPath();

        try {
            NewsFactory newsReader = new NewsFactory(resource_path);
            ArrayList<News> newsList= newsReader.fetch();
            NewsListViewer newsViewer = new NewsListViewer(newsList);
            newsViewer.display();
        } catch (Exception e) {
            System.out.println("新闻文件夹不存在");
        }
    }
}
