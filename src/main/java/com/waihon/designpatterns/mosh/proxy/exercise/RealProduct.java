package com.waihon.designpatterns.mosh.proxy.exercise;

public class RealProduct implements Product {
    protected int id;
    protected String name;

    public RealProduct(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }
}
