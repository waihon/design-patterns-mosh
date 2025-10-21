package com.waihon.designpatterns.mosh.chainofresponsibility.exercise;

public class ExcelReader extends DataReader {
    public ExcelReader(DataReader next) {
        super(next);
    }

    @Override
    protected String getExtension() {
        return ".xlsx";
    }

    @Override
    public void doRead(String fileName) {
        System.out.println("Reading data from an Excel spreadsheet.");
    }
}
