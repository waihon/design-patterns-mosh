package com.waihon.designpatterns.mosh.iterator.open;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class BrowserHistoryTest {

    BrowserHistory history;

    @BeforeEach
    void setUp() {
        history = new BrowserHistory();
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

    @Test
    void historyDoesNotExposetAListOfUrls() {
        boolean methodExists = Arrays.stream(BrowserHistory.class.getDeclaredMethods())
                .anyMatch(m -> m.getName().equals("getUrls") &&
                        m.getParameterCount() == 0);
        assertThat(methodExists).isEqualTo(false);
    }

    @Test
    void historyCanCreateAnIterator() {
        Object iterator = history.createIterator();
        boolean instanceOfIterator = iterator instanceof Iterator;
        assertThat(instanceOfIterator).isEqualTo(true);
    }

}
