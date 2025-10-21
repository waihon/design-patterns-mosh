package com.waihon.designpatterns.mosh.chainofresponsibility.exercise;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.github.stefanbirkner.systemlambda.SystemLambda.tapSystemOut;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class ChainOfResponsibilityTest {
    private DataReader reader;

    @BeforeEach
    void setUp() {
        reader = DataReaderFactory.getDataReaderChain();
    }

    @Test
    void readExcelSpreadsheet() throws Exception {
        var text = tapSystemOut(() -> {
            reader.read("data.xlsx");
        });

        assertThat(text).contains("Reading data from an Excel spreadsheet.");
    }

    @Test
    void readNumbersSpreadsheet() throws Exception {
        var text = tapSystemOut(() -> {
            reader.read("data.numbers");
        });

        assertThat(text).contains("Reading data from a Numbers spreadsheet.");
    }

    @Test
    void readQuickBookWorkbook() throws Exception {
        var text = tapSystemOut(() -> {
            reader.read("data.qbw");
        });

        assertThat(text).contains("Reading data from a QuickBooks file.");
    }

    @Test
    void readUnsupportedFileFormat() throws Exception {
        try {
            reader.read("data.jpg");

        } catch (Exception e) {
            assertThat(e.getMessage()).contains("File format not supported.");
        }
    }

}
