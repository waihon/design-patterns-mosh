package com.waihon.designpatterns.mosh.observer.exercise;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.github.stefanbirkner.systemlambda.SystemLambda.tapSystemOut;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class StatusBarTest {
    private Stock stock1;
    private Stock stock2;
    private StatusBar statusBar;

    @BeforeEach
    void setUp() {
        stock1 = new Stock("NVDA", 183.22f);
        stock2 = new Stock("AAPL", 252.29f);
        statusBar = new StatusBar();

        statusBar.addStock(stock1);
        statusBar.addStock(stock2);
    }

    @Test
    void showStocks() throws Exception {
        var text = tapSystemOut(() -> {
            statusBar.show();
        });

        assertThat(text).doesNotContain("Priced Changed - Refreshing StatusBar");
        assertThat(text).contains("Stock{symbol='NVDA', price=183.22}");
        assertThat(text).contains("Stock{symbol='AAPL', price=252.29}");
        assertThat(text).doesNotContain("Stock{symbol='GOOG', price=253.79}");
        assertThat(text).doesNotContain("Stock{symbol='AMZN', price=213.04}");
        assertThat(text).doesNotContain("Stock{symbol='MSFT', price=513.58}");
    }

    @Test
    void stockPricesGotUpdated() throws Exception {
        var text = tapSystemOut(() -> {
            stock1.setPrice(180.00f);
            stock2.setPrice(250.00f);
        });

        assertThat(text).contains("Priced Changed - Refreshing StatusBar");
        assertThat(text).contains("Stock{symbol='NVDA', price=180.0}");
        assertThat(text).contains("Stock{symbol='AAPL', price=250.0}");
    }
}
