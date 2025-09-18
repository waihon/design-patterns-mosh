package com.waihon.designpatterns.mosh.template.exercise;

public class DialogBox extends Window {

    @Override
    protected void beforeClose() {
        System.out.println("Dialog Box Before Close");
    }

    @Override
    protected void closeWindow() {
        System.out.println("Dialog Box Close Window");
    }

    @Override
    protected void afterClose() {
        System.out.println("Dialog Box After Close");
    }
}
