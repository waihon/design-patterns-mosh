package com.waihon.designpatterns.mosh.strategy;

public class HighContrastFilter implements Filter {
    @Override
    public void apply() {
        System.out.println("Filtering using High Contrast.");
    }
}
