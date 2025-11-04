package com.waihon.designpatterns.mosh.adapter.exercise;

import com.waihon.designpatterns.mosh.adapter.exercise.gmail.GmailClient;

public class GmailProvider implements EmailProvider {
    private GmailClient gmailClient;

    public GmailProvider(GmailClient gmailClient) {
        this.gmailClient = gmailClient;
    }

    @Override
    public void downloadEmails() {
        gmailClient.connect();
        gmailClient.getEmails();
        gmailClient.disconnect();
    }
}
