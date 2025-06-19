package com.waihon.designpatterns.mosh.iterator;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class SimpleBrowserHistoryTest {

    @Test
    void historyShouldIncreaseInSizeWhenPushed() {
        SimpleBrowserHistory history = new SimpleBrowserHistory();
        history.push("https://example.com");
        assertThat(history.getSize()).isEqualTo(1);
    }

    @Test
    void histroyShouldDecreaseInSizeWhenPopped() {
        SimpleBrowserHistory history = new SimpleBrowserHistory();
        history.push("https://example.com");
        history.pop();
        assertThat(history.getSize()).isEqualTo(0);
    }

    @Test
    void historyShouldReturnLastItemWhenPopped() {
        SimpleBrowserHistory history = new SimpleBrowserHistory();
        history.push("https://example.com");
        history.push("https://example.org");
        String lastItem = history.pop();
        assertThat(lastItem).isEqualTo("https://example.org");
    }

    @Test
    void emptyHistoryShouldReturnNullWhenPopped() {
        SimpleBrowserHistory history = new SimpleBrowserHistory();
        String lastItem = history.pop();
        assertThat(lastItem).isNull();
    }

}
