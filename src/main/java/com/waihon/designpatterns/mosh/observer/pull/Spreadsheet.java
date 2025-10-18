package com.waihon.designpatterns.mosh.observer.pull;

public class Spreadsheet implements Observer {
    private String name;
    private DataSource dataSource;

    public Spreadsheet(String name, DataSource dataSource) {
        this.name = name;
        this.dataSource = dataSource;
    }

    @Override
    public void update() {
        System.out.println("Spreadsheet '" + name + "' got updated: " + dataSource.getValue() + ".");
    }
}
