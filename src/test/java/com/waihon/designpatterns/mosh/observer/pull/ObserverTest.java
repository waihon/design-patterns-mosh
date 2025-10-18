package com.waihon.designpatterns.mosh.observer.pull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.github.stefanbirkner.systemlambda.SystemLambda.tapSystemOut;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class ObserverTest {
    private DataSource dataSource;
    private Spreadsheet spreadsheet1;
    private Spreadsheet spreadsheet2;
    private Chart chart1;
    private int value;

    @BeforeEach
    void setUp() {
        dataSource = new DataSource();
        spreadsheet1 = new Spreadsheet("Sheet 1", dataSource);
        spreadsheet2 = new Spreadsheet("Sheet 2", dataSource);
        chart1 = new Chart("Chart 1", dataSource);
        value = 11;
    }

    @Test
    void testSingleObserver() throws Exception {
        dataSource.addObserver(spreadsheet2);

        var text = tapSystemOut(() -> {
            dataSource.setValue(value);
        });

        assertThat(text).doesNotContain("Spreadsheet 'Sheet 1' got updated: " + value + ".");
        assertThat(text).contains("Spreadsheet 'Sheet 2' got updated: " + value + ".");
        assertThat(text).doesNotContain("Chart 'Chart 1' got updated: " + value + ".");
    }

    @Test
    void testMultipleObservers() throws Exception {
        dataSource.addObserver(spreadsheet1);
        dataSource.addObserver(spreadsheet2);
        dataSource.addObserver(chart1);

        var text = tapSystemOut(() -> {
            dataSource.setValue(value);
        });

        assertThat(text).contains("Spreadsheet 'Sheet 1' got updated: " + value + ".");
        assertThat(text).contains("Spreadsheet 'Sheet 2' got updated: " + value + ".");
        assertThat(text).contains("Chart 'Chart 1' got updated: " + value + ".");
    }

}
