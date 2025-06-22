package com.waihon.designpatterns.mosh.strategy;

public class SimpleImageStorage {

    private CompressorType compressor;
    private FilterType filter;

    public void store(String fileName) {
        if (compressor == CompressorType.JPEG) {
            System.out.println("Compressing using JPEG.");
        } else if (compressor == CompressorType.PNG) {
            System.out.println("Compressing using PNG.");
        }

        if (filter == FilterType.BLACK_AND_WHITE) {
            System.out.println("Filtering using Black and White.");
        } else if (filter == FilterType.HIGH_CONTRAST) {
            System.out.println("Filtering using High Contrast.");
        }
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
