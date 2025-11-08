package com.waihon.designpatterns.mosh.facade.exercise;

import java.util.List;

public class TwitterClient {
    public List<Tweet> getRecentTweets(String accessToken) {
        System.out.println("Getting recent tweets...");

        Tweet tweet1 = new Tweet("First post of the day!");
        Tweet tweet2 = new Tweet("A follow-up thought.");
        Tweet tweet3 = new Tweet("The final message.");

        return List.of(tweet1, tweet2, tweet3);
    }

}
