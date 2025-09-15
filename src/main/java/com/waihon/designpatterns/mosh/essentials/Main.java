package com.waihon.designpatterns.mosh.essentials;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        User user = new User("Waihon");
        user.sayHello();

        TaxCalculator calculator = getCalculator();
        System.out.println(calculator.calculateTax());
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
