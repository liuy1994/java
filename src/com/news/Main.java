package com.news;
public class Main {
    public static void main(String[] args) {
        News news = new News("title-main", "content-main");
        news.display();
        UrlNews urlNews = new UrlNews("url-main", "title-url-main", "content-url-main");
        urlNews.display();
        News urlNews2 = new UrlNews("url-main-2", "title-url-main-2", "content-url-main-2");
        urlNews2.display();
        NewsReader urlNewsReader = new UrlNewsReader();
        News result = urlNewsReader.readNews("url-news-reader");
        result.display();
    }
}
