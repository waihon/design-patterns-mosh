package com.waihon.designpatterns.mosh.essentials;

public abstract class UIControl {
    public void enable() {
        System.out.println("Enabled");
    }

    public abstract void draw();
}
