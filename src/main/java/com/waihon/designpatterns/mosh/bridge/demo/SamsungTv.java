package com.waihon.designpatterns.mosh.bridge.demo;

public class SamsungTv implements Device {
    @Override
    public void turnOn() {
        System.out.println("Samsung TV: turnOn");
    }

    @Override
    public void turnOff() {
        System.out.println("Samsung TV: turnOff");
    }

    @Override
    public void setChannel(int channel) {
        System.out.printf("Samsung TV: setChannel(%d)\n", channel);
    }
}
