package com.waihon.designpatterns.mosh.decorator.demo;

public class CompressedStream implements Stream {
    private Stream stream;

    public CompressedStream(Stream stream) {
        this.stream = stream;
    }

    @Override
    public void write(String data) {
        var compressed = compress(data);

        stream.write(compressed);
    }

    private String compress(String data) {
        int half = data.length() / 2;

        return data.substring(0, half);
    }
}
