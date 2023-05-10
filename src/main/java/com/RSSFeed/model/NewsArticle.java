package com.RSSFeed.model;

import java.util.List;

public class NewsArticle {
    private String title;
    private String link;
    private String publishedDate;



    // getters and setters


    public String getPublishedDate() {
        return publishedDate;
    }

    public void setPublishedDate(String publishedDate) {
        this.publishedDate = publishedDate;
    }

    public String getTitle() {
        return title;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    // getter and setters done!
    @Override
    public String toString(){
        return publishedDate+" | "+title+" | "+link;
    }
}
