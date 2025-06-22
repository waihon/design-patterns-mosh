package com.waihon.designpatterns.mosh.strategy;

public class JpegCompressor implements Compressor {
    @Override
    public void compress() {
        System.out.println("Compressing using JPEG.");
    }
}
