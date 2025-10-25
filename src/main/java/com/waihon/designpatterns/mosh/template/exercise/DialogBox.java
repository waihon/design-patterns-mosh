package com.waihon.designpatterns.mosh.template.exercise;

public class DialogBox extends Window {

    @Override
    protected void beforeClose() {
        System.out.println("Before closing Dialog Box");
    }

    @Override
    protected void afterClose() {
        System.out.println("After closing Dialog Box");
    }
}
