package com.waihon.designpatterns.mosh.facade.exercise;

import java.util.List;

public class TwitterService {
    private String accessToken;
    private TwitterClient client;

    public TwitterService(String appKey, String appSecret) {
        var oauth = new OAuth();
        var requestToken = oauth.requestToken(appKey, appSecret);

        accessToken = oauth.accessToken(requestToken);
        client = new TwitterClient();
    }

    public List<Tweet> getRecentTweets() {
        return client.getRecentTweets(accessToken);
    }
}
