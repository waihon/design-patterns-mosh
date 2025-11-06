package com.waihon.designpatterns.mosh.decorator.demo;

public class CloudStream implements Stream {
    @Override
    public void write(String data) {
        System.out.println("Storing " + data);
    }
}
