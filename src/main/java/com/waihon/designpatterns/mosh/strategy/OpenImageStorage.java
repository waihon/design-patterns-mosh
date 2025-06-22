package com.waihon.designpatterns.mosh.strategy;

public class OpenImageStorage {

    private Compressor compressor;
    private Filter filter;

    public void store(String fileName) {
        compressor.compress();

        filter.apply();
    }

    public Compressor getCompressor() {
        return compressor;
    }

    public void setCompressor(Compressor compressor) {
        this.compressor = compressor;
    }

    public Filter getFilter() {
        return filter;
    }

    public void setFilter(Filter filter) {
        this.filter = filter;
    }

}
