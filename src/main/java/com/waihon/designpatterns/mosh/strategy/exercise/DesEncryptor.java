package com.waihon.designpatterns.mosh.strategy.exercise;

public class DesEncryptor implements Encryptor {
    @Override
    public String encrypt(String message) {
        System.out.println("Encrypting message using DES");
        return "Encrypted " + message;
    }
}
