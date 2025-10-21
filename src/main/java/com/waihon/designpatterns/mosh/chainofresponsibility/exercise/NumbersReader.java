package com.waihon.designpatterns.mosh.chainofresponsibility.exercise;

public class NumbersReader extends DataReader {
    public NumbersReader(DataReader next) {
        super(next);
    }

    @Override
    protected String getExtension() {
        return ".numbers";
    }

    @Override
    protected void doRead(String fileName) {
        System.out.println("Reading data from a Numbers spreadsheet.");
    }
}
