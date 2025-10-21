package com.waihon.designpatterns.mosh.chainofresponsibility.exercise;

public class DataReaderFactory {
    public static DataReader getDataReaderChain() {
        QuickBookReader quickBookReader = new QuickBookReader(null);
        NumbersReader numbersReader = new NumbersReader(quickBookReader);
        ExcelReader excelReader = new ExcelReader(numbersReader);

        return excelReader;
    }
}
