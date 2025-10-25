package com.waihon.designpatterns.mosh.template.exercise;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.github.stefanbirkner.systemlambda.SystemLambda.tapSystemOut;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class AppWindowTest {
    private Window window;

    @BeforeEach
    void setUp() {
        window = new AppWindow();
    }

    @Test
    void shouldExecuteBefore() throws Exception {
        var text = tapSystemOut(() -> {
            window.close();
        });

        assertThat(text).contains("Before closing App Window");
    }

    @Test
    void shouldClose() throws Exception {
        var text = tapSystemOut(() -> {
            window.close();
        });

        assertThat(text).contains("Close App Window");
    }

    @Test
    void shouldExecuteAfter() throws Exception {
        var text = tapSystemOut(() -> {
            window.close();
        });

        assertThat(text).contains("After closing App Window");
    }
}
