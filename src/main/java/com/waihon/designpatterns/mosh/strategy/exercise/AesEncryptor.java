package com.waihon.designpatterns.mosh.strategy.exercise;

public class AesEncryptor implements Encryptor {
    @Override
    public String encrypt(String message) {
        System.out.println("Encrypting message using AES");
        return "Encrypted " + message;
    }
}
