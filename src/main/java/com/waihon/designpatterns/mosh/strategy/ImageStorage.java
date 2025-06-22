package com.waihon.designpatterns.mosh.strategy;

public class ImageStorage {

    private CompressorType compressor;

    public void store(String fileName) {
        if (compressor == CompressorType.JPEG) {
            System.out.println("Compressing using JPEG.");
        } else if (compressor == CompressorType.PNG) {
            System.out.println("Compressing using PNG.");
        }
    }

    public CompressorType getCompressor() {
        return compressor;
    }

    public void setCompressor(CompressorType compressor) {
        this.compressor = compressor;
    }
}
