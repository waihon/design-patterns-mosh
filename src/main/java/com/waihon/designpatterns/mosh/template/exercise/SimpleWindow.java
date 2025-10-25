package com.waihon.designpatterns.mosh.template.exercise;

public class SimpleWindow extends Window {
    @Override
    protected void beforeClose() {
        // No
        return;
    }

    @Override
    protected void afterClose() {
        return;
    }
}
