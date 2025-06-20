package com.waihon.designpatterns.mosh.iterator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class SimpleBrowserHistoryTest {

    SimpleBrowserHistory history;

    @BeforeEach
    void setUp() {
        history = new SimpleBrowserHistory();
    }

    @Test
    void historyShouldIncreaseInSizeWhenPushed() {
        history.push("https://example.com");
        assertThat(history.getSize()).isEqualTo(1);
    }

    @Test
    void histroyShouldDecreaseInSizeWhenPopped() {
        history.push("https://example.com");
        history.pop();
        assertThat(history.getSize()).isEqualTo(0);
    }

    @Test
    void historyShouldReturnLastItemWhenPopped() {
        history.push("https://example.com");
        history.push("https://example.org");
        String lastItem = history.pop();
        assertThat(lastItem).isEqualTo("https://example.org");
    }

    @Test
    void emptyHistoryShouldReturnNullWhenPopped() {
        String lastItem = history.pop();
        assertThat(lastItem).isNull();
    }

}
