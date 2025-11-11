package com.waihon.designpatterns.mosh.proxy.solution;

public class Product {
    protected int id;
    protected String name;

    public Product(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
