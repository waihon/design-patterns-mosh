package com.waihon.designpatterns.mosh.template.exercise;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.github.stefanbirkner.systemlambda.SystemLambda.tapSystemOut;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class DialogBoxTest {
    private Window window;

    @BeforeEach
    void setUp() {
        window = new DialogBox();
    }

    @Test
    void shouldExecuteBefore() throws Exception {
        var text = tapSystemOut(() -> {
            window.close();
        });

        assertThat(text).contains("Before closing Dialog Box");
    }

    @Test
    void shouldCloseWindow() throws Exception {
        var text = tapSystemOut(() -> {
            window.close();
        });

        // Default logic of closeWindow()
        assertThat(text).contains("Close Window");
    }

    @Test
    void shouldExecuteAfter() throws Exception {
        var text = tapSystemOut(() -> {
            window.close();
        });

        assertThat(text).contains("After closing Dialog Box");
    }

}
