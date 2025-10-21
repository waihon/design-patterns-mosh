package com.waihon.designpatterns.mosh.chainofresponsibility.exercise;

public class QuickBookReader extends DataReader {
    public QuickBookReader(DataReader next) {
        super(next);
    }

    @Override
    protected String getExtension() {
        return ".qbw";
    }

    @Override
    protected void doRead(String fileName) {
        System.out.println("Reading data from a QuickBooks file.");
    }
}
