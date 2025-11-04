package com.waihon.designpatterns.mosh.adapter.exercise;

public class YahooProvider implements EmailProvider {
    @Override
    public void downloadEmails() {
        System.out.println("Downloading emails from Yahoo");
    }
}
