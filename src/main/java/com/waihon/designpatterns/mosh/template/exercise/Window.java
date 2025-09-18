package com.waihon.designpatterns.mosh.template.exercise;

public abstract class Window {
    public void close() {
        this.beforeClose();

        this.closeWindow();

        this.afterClose();
    }

    protected abstract void beforeClose();

    protected void closeWindow() {
        System.out.println("Window Close");
    }

    protected abstract void afterClose();
}
