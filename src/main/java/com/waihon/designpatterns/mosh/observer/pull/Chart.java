package com.waihon.designpatterns.mosh.observer.pull;

public class Chart implements Observer {
    private String name;
    private DataSource dataSource;

    public Chart(String name, DataSource dataSource) {
        this.name = name;
        this.dataSource = dataSource;
    }

    @Override
    public void update() {
        System.out.println("Chart '" + name + "' got updated: " + dataSource.getValue() + ".");
    }
}
