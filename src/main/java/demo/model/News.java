package demo.model;

import java.util.*;

public class News {
    private String tittle;
    private String content;


    private Map<String, String> related;
    public News(String tittle, String content) {
        this.tittle = tittle;
        this.content = content;
        this.related = new HashMap<String, String>();
    }
    public void addRelated(String date, String related_title) {
        related.put(date, related_title);
    }

    public String getRelated() {
        String result = "";
        for (Map.Entry<String, String> entry : related.entrySet()) {
            result += entry.getKey() + ":" + entry.getValue() + "\n";
        }
        return result;
    }

    public String getTittle() {
        return tittle;
    }

    public String getContent() {
        return content;
    }
}
