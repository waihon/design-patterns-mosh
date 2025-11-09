package com.waihon.designpatterns.mosh.bridge.demo;

public class SonyTv implements Device {
    @Override
    public void turnOn() {
        System.out.println("Sony TV: turnOn");
    }

    @Override
    public void turnOff() {
        System.out.println("Sony TV: turnOff");
    }

    @Override
    public void setChannel(int channel) {
        System.out.printf("Sony TV: setChannel(%d)\n", channel);
    }
}
