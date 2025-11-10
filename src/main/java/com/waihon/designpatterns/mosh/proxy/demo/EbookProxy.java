package com.waihon.designpatterns.mosh.proxy.demo;

public class EbookProxy implements Ebook {
    private String fileName;
    private RealEbook ebook;

    public EbookProxy(String fileName) {
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

        ebook.show();
    }
}
