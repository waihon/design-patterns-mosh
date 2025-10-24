package com.waihon.designpatterns.mosh.strategy.open;

public class PngCompressor implements Compressor {
    @Override
    public void compress() {
        System.out.println("Compressing using PNG.");
    }
}
