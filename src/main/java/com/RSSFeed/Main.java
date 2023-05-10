package com.RSSFeed;

import com.RSSFeed.controller.ManagerUtility;
import com.RSSFeed.model.NewsArticle;
import com.rometools.rome.io.FeedException;

import java.net.URISyntaxException;
import java.io.IOException;
import java.net.URL;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException, FeedException,URISyntaxException, InterruptedException {

        URL feedSource = new URL("https://cloudblog.withgoogle.com/rss/");
        List<String> targetFeedsList = List.of("https://cloudblog.withgoogle.com/rss/",
                "https://medium.com/feed/google-cloud","https://blog.jetbrains.com/kotlin/feed/"
                );
        for (String url:targetFeedsList){
            List<NewsArticle>results= ManagerUtility.read(url);
            System.out.println("url : "+url);
            results.stream().forEach(ele->System.out.println(ele.toString()));
            System.out.println("=========================================");

        }

    }
}