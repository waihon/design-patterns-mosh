package com.waihon.designpatterns.mosh.observer.push;

public class Chart implements Observer {
    private String name;

    public Chart(String name) {
        this.name = name;
    }

    @Override
    public void update(int value) {
        System.out.println("Chart '" + name + "' got updated: " + value + ".");
    }
}
