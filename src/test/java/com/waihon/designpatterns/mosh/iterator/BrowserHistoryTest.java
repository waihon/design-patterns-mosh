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

}
