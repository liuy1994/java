package demo.model;

import java.io.*;
import java.util.*;

public class NewsFactory {

    private File newdDir;
    public NewsFactory(String dir) throws Exception {
        newdDir = new File(dir);
        if (!newdDir.exists()) {
            throw new Exception("新闻文件夹不存在");
        }

        if (!newdDir.isDirectory()) {
            throw new Exception("新闻文件夹不是文件夹");
        }
    }

    public ArrayList<News> fetch() {
        ArrayList<News> newsList = new ArrayList<News>();
        File[] files = newdDir.listFiles();
        if (files != null) {
            for (File file : files) {
                try {
                    FileReader fileReader = new FileReader(file);
                    BufferedReader reader = new BufferedReader(fileReader);
                    String title = reader.readLine();
                    reader.readLine();
                    String content = reader.readLine();
                    News news = new News(title, content);
                    reader.readLine();

                    String date = reader.readLine();
                    while (date != null) {
                        String related_title = reader.readLine();
                        news.addRelated(date, related_title);
                        date = reader.readLine();
                    }
                    newsList.add(news);

                } catch (Exception e) {
                    System.out.println("新闻读取出错");
                }
            }
        }
        return newsList;
    }
}
