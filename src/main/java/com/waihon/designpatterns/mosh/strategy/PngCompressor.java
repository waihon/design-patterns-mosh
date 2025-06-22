package com.waihon.designpatterns.mosh.strategy;

public class PngCompressor implements Compressor {
    @Override
    public void compress() {
        System.out.println("Compressing using PNG.");
    }
}
