package com.waihon.designpatterns.mosh.strategy.exercise;

public class ChatClient {
    private Encryptor encryptor;

    public ChatClient(Encryptor encryptor) {
        this.encryptor = encryptor;
    }

    public void send(String message) {
        String encryptedMessage = encryptor.encrypt(message);

        System.out.println("Sending the encrypted message...");
        System.out.println(encryptedMessage);
    }
}
