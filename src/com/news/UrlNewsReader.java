package com.news;
public class UrlNewsReader extends NewsReader {
    public News readNews(String url) {
        return new UrlNews(url, "TITLE-UrlNews", "CONTENT-UrlNews");
    }
}
