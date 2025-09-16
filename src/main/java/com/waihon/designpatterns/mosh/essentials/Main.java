package com.waihon.designpatterns.mosh.essentials;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        // Classes
        User user = new User("Waihon");
        user.sayHello();

        // Interfaces
        TaxCalculator calculator = getCalculator();
        System.out.println(calculator.calculateTax());

        // Encapsulation
        var account = new Account();
        account.deposit(100);
        account.withdraw(45);
        System.out.println(account.getBalance());

        // Abstraction
        var mailService = new MailService();
        mailService.sendEmail();
    }

    public static TaxCalculator getCalculator() {
        Random random = new Random();
        if (random.nextBoolean()) {
            return new TaxCalculator2019();
        } else {
            return new TaxCalculator2020();
        }

    }
}
