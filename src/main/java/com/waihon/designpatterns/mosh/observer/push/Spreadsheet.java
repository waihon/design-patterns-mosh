package com.waihon.designpatterns.mosh.observer.push;

public class Spreadsheet implements Observer<Integer> {
    private String name;

    public Spreadsheet(String name) {
        this.name = name;
    }

    @Override
    public void update(Integer value) {
        System.out.println("Spreadsheet '" + name + "' got updated: " + value + ".");
    }
}
