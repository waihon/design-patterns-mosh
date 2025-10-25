package com.waihon.designpatterns.mosh.template.exercise;

public class AppWindow extends Window {
    @Override
    protected void beforeClose() {
        System.out.println("Before closing App Window");
    }

    @Override
    protected  void closeWindow() {
        System.out.println("Close App Window");
    }

    @Override
    protected void afterClose() {
        System.out.println("After closing App Window");
    }
}
