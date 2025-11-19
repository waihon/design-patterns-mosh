package com.waihon.designpatterns.mosh.builder.demo;

public class PdfDocument {
    private int pageCount = 0;

    public void addPage(String text) {
        pageCount++;
        System.out.printf("Adding a page to PDF: %s\n", text);
    }

    public int getPageCount() {
        return pageCount;
    }
}
