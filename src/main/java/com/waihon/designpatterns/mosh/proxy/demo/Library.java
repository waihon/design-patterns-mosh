package com.waihon.designpatterns.mosh.proxy.demo;

import java.util.HashMap;
import java.util.Map;

public class Library {
    private Map<String, Ebook> ebooks = new HashMap<>();

    public void add(Ebook ebook) {
        var fileName = ebook.getFileName();

        ebooks.put(fileName, ebook);
    }

    public void openEbook(String fileName) {
        if (!ebooks.containsKey(fileName)) {
            System.out.printf("Cannot find ebook '%s'\n.", fileName);
            return;
        }

        var ebook = ebooks.get(fileName);
        ebook.show();
    }
}
