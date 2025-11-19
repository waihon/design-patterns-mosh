package com.waihon.designpatterns.mosh.builder.demo;

public class PdfDocument {
    private int pages = 0;

    public void addPage(String text) {
        pages++;
        System.out.printf("Adding a page to PDF: %s\n", text);
    }

    public int getPages() {
        return pages;
    }
}
