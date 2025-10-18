package com.waihon.designpatterns.mosh.observer.exercise;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.github.stefanbirkner.systemlambda.SystemLambda.tapSystemOut;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class StockListViewTest {
    private StockListView stockListView;
    private Stock stock1;
    private Stock stock2;
    private Stock stock3;
    private Stock stock4;
    private Stock stock5;

    @BeforeEach
    void setUp() {
        stock1 = new Stock("NVDA", 183.22f);
        stock2 = new Stock("AAPL", 252.29f);
        stock3 = new Stock("GOOG", 253.79f);
        stock4 = new Stock("AMZN", 213.04f);
        stock5 = new Stock("MSFT", 513.58f);

        stockListView = new StockListView();
        stockListView.addStock(stock1);
        stockListView.addStock(stock2);
        stockListView.addStock(stock3);
        stockListView.addStock(stock4);
        stockListView.addStock(stock5);
    }

    @Test
    void showStocks() throws Exception {
        var text = tapSystemOut(() -> {
            stockListView.show();
        });

        assertThat(text).contains("Stock{symbol='NVDA', price=183.22}");
        assertThat(text).contains("Stock{symbol='AAPL', price=252.29}");
        assertThat(text).contains("Stock{symbol='GOOG', price=253.79}");
        assertThat(text).contains("Stock{symbol='AMZN', price=213.04}");
        assertThat(text).contains("Stock{symbol='MSFT', price=513.58}");
    }
}
