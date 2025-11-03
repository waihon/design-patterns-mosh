package com.waihon.designpatterns.mosh.adapter.demo;

public class VividFilter implements Filter {
    @Override
    public void apply(Image image) {
        System.out.println("Applying Vivid Filter to '" + image.getName() + "'");
    }
}
