package com.waihon.designpatterns.mosh.facade.demo;

import java.sql.SQLOutput;

public class NotificationService {
    public void send(String message, String target) {
        var server = new NotificationServer();
        var connection = server.connect("ipAddress");
        var authToken = server.authenticate("appID", "key");
        server.send(authToken, new Message(message), target);
        connection.disconnect();
    }
}
