package com.waihon.designpatterns.mosh.strategy;

public class ImageStorage {

    private CompressorType compressor;

    public void store(String fileName) {
        System.out.println("Compressing using JPEG.");
        System.out.println("Applying B&W filter.");
    }

    public CompressorType getCompressor() {
        return compressor;
    }

    public void setCompressor(CompressorType compressor) {
        this.compressor = compressor;
    }
}
