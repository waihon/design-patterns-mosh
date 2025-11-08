package com.waihon.designpatterns.mosh.facade.exercise;

public class Tweet {
    private String message;

    public Tweet(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
