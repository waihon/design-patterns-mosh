package com.waihon.designpatterns.mosh.adapter.exercise;

import com.waihon.designpatterns.mosh.adapter.exercise.gmail.GmailClient;

public class GmailProvider implements EmailProvider {
    private GmailClient gmailClient = new GmailClient();

    @Override
    public void downloadEmails() {
        gmailClient.connect();
        gmailClient.getEmails();
        gmailClient.disconnect();
    }
}
