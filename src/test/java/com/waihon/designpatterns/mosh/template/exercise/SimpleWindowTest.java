package com.waihon.designpatterns.mosh.template.exercise;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.github.stefanbirkner.systemlambda.SystemLambda.tapSystemOut;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class SimpleWindowTest {
    private Window window;

    @BeforeEach
    void setUp() {
        window = new SimpleWindow();
    }

    @Test
    void shouldExecuteBefore() throws Exception {
        var text = tapSystemOut(() -> {
            window.close();
        });

        assertThat(text).doesNotContain("Before closing");
    }

    @Test
    void shouldCloseWindow() throws Exception {
        var text = tapSystemOut(() -> {
            window.close();
        });

        // Default implementation
        assertThat(text).contains("Close Window");
    }

    @Test
    void shouldExecuteAfter() throws Exception {
        var text = tapSystemOut(() -> {
            window.close();
        });

        assertThat(text).doesNotContain("After closing");
    }

}
