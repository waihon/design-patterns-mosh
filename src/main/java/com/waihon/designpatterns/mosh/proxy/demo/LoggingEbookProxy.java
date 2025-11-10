package com.waihon.designpatterns.mosh.proxy.demo;

public class LoggingEbookProxy implements Ebook {
    private String fileName;
    private RealEbook ebook;

    public LoggingEbookProxy(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public String getFileName() {
        return fileName;
    }

    @Override
    public void show() {
        if (ebook == null) {
            ebook = new RealEbook(fileName);
        }

        System.out.printf("Logging the ebook '%s'\n", fileName);

        ebook.show();
    }
}
