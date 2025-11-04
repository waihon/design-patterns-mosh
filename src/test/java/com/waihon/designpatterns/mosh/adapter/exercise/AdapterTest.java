package com.waihon.designpatterns.mosh.adapter.exercise;

import com.waihon.designpatterns.mosh.adapter.exercise.gmail.GmailClient;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.github.stefanbirkner.systemlambda.SystemLambda.tapSystemOut;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class AdapterTest {
    private static final String YAHOO_DOWNLOAD = "Downloading emails from Yahoo";
    private static final String GMAIL_CONNECT = "Connecting to Gmail";
    private static final String GMAIL_DOWNLOAD = "Downloading emails from Gmail";
    private static final String GMAIL_DISCONNECT = "Disconnecting from Gmail";

    private EmailClient emailClient;
    private YahooProvider yahooProvider;
    private GmailProvider gmailProvider;

    @BeforeEach
    void setUp() {
        yahooProvider = new YahooProvider();
        gmailProvider = new GmailProvider();
        
        emailClient = new EmailClient();
        emailClient.addProvider(yahooProvider);
        emailClient.addProvider(gmailProvider);
    }

    @Test
    void yahooProviderDownloadsEmails() throws Exception {
        var text = tapSystemOut(() -> {
            yahooProvider.downloadEmails();
        });

        assertThat(text).contains(YAHOO_DOWNLOAD);
        assertThat(text).doesNotContain(GMAIL_CONNECT);
        assertThat(text).doesNotContain(GMAIL_DOWNLOAD);
        assertThat(text).doesNotContain(GMAIL_DISCONNECT);
    }

    @Test
    void gmailProviderDownloadsEmails() throws Exception {
        var text = tapSystemOut(() -> {
            gmailProvider.downloadEmails();
        });

        assertThat(text).contains(GMAIL_CONNECT);
        assertThat(text).contains(GMAIL_DOWNLOAD);
        assertThat(text).contains(GMAIL_DISCONNECT);
        assertThat(text).doesNotContain(YAHOO_DOWNLOAD);
    }

    @Test
    void emailClientDownloadsEmails() throws Exception {
        var text = tapSystemOut(() -> {
            emailClient.downloadEmails();
        });

        assertThat(text).contains(YAHOO_DOWNLOAD);
        assertThat(text).contains(GMAIL_CONNECT);
        assertThat(text).contains(GMAIL_DOWNLOAD);
        assertThat(text).contains(GMAIL_DISCONNECT);
    }
}
