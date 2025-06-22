package com.waihon.designpatterns.mosh.strategy;

public class ImageStorage {

    private CompressorType compressor;
    private FilterType filter;

    public void store(String fileName) {
        if (compressor == CompressorType.JPEG) {
            System.out.println("Compressing using JPEG.");
        } else if (compressor == CompressorType.PNG) {
            System.out.println("Compressing using PNG.");
        }

        System.out.println("Filtering using Black and White.");
    }

    public CompressorType getCompressor() {
        return compressor;
    }

    public void setCompressor(CompressorType compressor) {
        this.compressor = compressor;
    }

    public FilterType getFilter() {
        return filter;
    }

    public void setFilter(FilterType filter) {
        this.filter = filter;
    }

}
