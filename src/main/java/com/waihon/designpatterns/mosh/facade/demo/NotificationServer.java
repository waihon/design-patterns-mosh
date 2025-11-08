package com.waihon.designpatterns.mosh.facade.demo;

public class NotificationServer {
    public Connection connect(String ipAddress) {
        return new Connection();
    }

    public AuthToken authenticate(String appId, String key) {
        return new AuthToken();
    }

    public void send(AuthToken authToken, Message message, String target) {
        var messageFormat = "Sending message '%s' to target '%s'...";
        System.out.println(String.format(messageFormat, message.getContent(), target));
    }
}
