package com.RSSFeed.controller;

import com.RSSFeed.model.NewsArticle;
import com.rometools.rome.feed.synd.SyndEntry;
import com.rometools.rome.feed.synd.SyndFeed;
import com.rometools.rome.io.FeedException;
import com.rometools.rome.io.SyndFeedInput;
import com.rometools.rome.io.XmlReader;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ManagerUtility {
    public static List<NewsArticle> read(String feedUrl) throws IOException,FeedException{
        URL feedSource = new URL(feedUrl);
        SyndFeedInput input = new SyndFeedInput();
        SyndFeed feed = input.build(new XmlReader(feedSource));
        Iterator itr =feed.getEntries().iterator();
        List<NewsArticle> results = new ArrayList<>();
        while (itr.hasNext()){
            SyndEntry syndEntry = (SyndEntry) itr.next();
            results.add(mapToArticle(syndEntry));
        }
        return results;
    }

    private static NewsArticle mapToArticle(SyndEntry syndEntry){
        NewsArticle newsArticle= new NewsArticle();
        newsArticle.setTitle(syndEntry.getTitle());
        newsArticle.setLink(syndEntry.getLink());
        newsArticle.setPublishedDate(syndEntry.getPublishedDate().toString());
        return newsArticle;
    }
}
