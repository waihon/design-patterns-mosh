package com.waihon.designpatterns.mosh.facade.exercise;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class FacadeTest {
    private TwitterService service;
    private final String TWEET1 = "First post of the day!";
    private final String TWEET2 = "A follow-up thought.";
    private final String TWEET3 = "The final message.";

    @BeforeEach
    void setUp() {
        service = new TwitterService("appKey", "secret");
    }

    @Test
    void getRecentTweets() {
        List<Tweet> recentTweets;
        recentTweets = service.getRecentTweets();

        assertThat(recentTweets)
                .as("Validating the sequence and content of thte tweets")
                .extracting(Tweet::getMessage)
                .containsExactly(TWEET1, TWEET2, TWEET3);
    }
}
