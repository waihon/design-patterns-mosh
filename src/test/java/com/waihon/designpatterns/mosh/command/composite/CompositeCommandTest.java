package com.waihon.designpatterns.mosh.command.composite;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static com.github.stefanbirkner.systemlambda.SystemLambda.tapSystemOut;

public class CompositeCommandTest {
    private CompositeCommand composite;
    private final String RESIZE = "Resize";
    private final String BLACK_AND_WHITE = "Black and White";

    @BeforeEach
    void setUp() {
        composite = new CompositeCommand();
        composite.add(new ResizeCommand());
        composite.add(new BlackAndWhiteCommand());
    }

    @Test
    void shouldExecuteMultipleCommands() throws Exception {
        var text = tapSystemOut(() -> {
            composite.execute();
        });

        assertThat(text).contains(RESIZE);
        assertThat(text).contains(BLACK_AND_WHITE);
    }

    @Test
    void shouldExecuteCommandsInCorrectOrder() throws Exception {
        var text = tapSystemOut(() -> {
            composite.execute();
        });

        int index1 = text.indexOf(RESIZE);
        int index2 = text.indexOf(BLACK_AND_WHITE);

        assertThat(index1).isLessThan(index2);
    }
}
