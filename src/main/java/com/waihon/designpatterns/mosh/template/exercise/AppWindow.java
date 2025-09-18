package com.waihon.designpatterns.mosh.template.exercise;

public class AppWindow extends Window {
    @Override
    protected void beforeClose() {
        System.out.println("App Window Before Close");
    }

    @Override
    protected  void closeWindow() {
        System.out.println("App Window Close");
    }

    @Override
    protected void afterClose() {
        System.out.println("App Window After Close");
    }
}
