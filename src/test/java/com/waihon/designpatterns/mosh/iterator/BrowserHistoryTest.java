package com.waihon.designpatterns.mosh.iterator;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class BrowserHistoryTest {

    @Test
    void historyShouldIncreaseInSizeWhenPushed() {
        BrowserHistory history = new BrowserHistory();
        history.push("https://example.com");
        assertThat(history.getSize()).isEqualTo(1);
    }

    @Test
    void histroyShouldDecreaseInSizeWhenPopped() {
        BrowserHistory history = new BrowserHistory();
        history.push("https://example.com");
        history.pop();
        assertThat(history.getSize()).isEqualTo(0);
    }

    @Test
    void historyShouldReturnLastItemWhenPopped() {
        BrowserHistory history = new BrowserHistory();
        history.push("https://example.com");
        history.push("https://example.org");
        String lastItem = history.pop();
        assertThat(lastItem).isEqualTo("https://example.org");
    }

    @Test
    void emptyHistoryShouldReturnNullWhenPopped() {
        BrowserHistory history = new BrowserHistory();
        String lastItem = history.pop();
        assertThat(lastItem).isNull();
    }

}
