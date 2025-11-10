package com.waihon.designpatterns.mosh.proxy.demo;

public class RealEbook implements Ebook {
    private String fileName;

    public RealEbook(String fileName) {
        this.fileName = fileName;
        load();
    }

    @Override
    public String getFileName() {
        return fileName;
    }

    @Override
    public void show() {
        System.out.printf("Showing the ebook '%s'\n", fileName);
    }

    private void load() {
        System.out.printf("Loading the ebook '%s'\n", fileName);
    }
}
