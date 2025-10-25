package com.waihon.designpatterns.mosh.iterator.open;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class IteratorTest {
    BrowserHistory history;
    Iterator<String> iterator;

    @BeforeEach
    void setUp() {
        history = new BrowserHistory();
        history.push("https://example.com");
        history.push("https://example.org");
        iterator = history.createIterator();
    }

    @Test
    void iteratorCanIterateOverBrowserHistory() {
        List<String> urls = new ArrayList<>();
        while (iterator.hasNext()) {
            String current = iterator.current();
            urls.add(current);
            iterator.next();
        }

        assertThat(urls).isEqualTo(Arrays.asList("https://example.com", "https://example.org"));
    }

}
