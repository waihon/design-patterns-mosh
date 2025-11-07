package com.waihon.designpatterns.mosh.decorator.exercise;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.github.stefanbirkner.systemlambda.SystemLambda.tapSystemOut;
import static org.assertj.core.api.Assertions.assertThat;

class DecoratorTest {
    private Editor editor;

    @BeforeEach
    void setUp() {
        editor = new Editor();
    }

    @Test
    void openProject() throws Exception {
        var text = tapSystemOut(() -> {
            editor.openProject("/projects/xyz");
        });

        assertThat(text.lines())
                .containsExactly(
                        "Main [Main]",
                        "Demo",
                        "EmailClient [Error]",
                        "EmailProvider [Error] [Main]"
                );
    }
}
