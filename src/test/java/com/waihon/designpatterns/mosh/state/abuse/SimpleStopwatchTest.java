package com.waihon.designpatterns.mosh.state.abuse;

import org.junit.jupiter.api.Test;

import static com.github.stefanbirkner.systemlambda.SystemLambda.tapSystemOut;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class SimpleStopwatchTest {

    @Test
    void stopwatchShouldRun_whenClicked_whenItIsStoped() throws Exception {
        SimpleStopwatch stopwatch = new SimpleStopwatch();

        String text = tapSystemOut(() -> {
            stopwatch.click();
        });

        assertThat(text.trim()).isEqualTo("Running");
    }

    @Test
    void stopwatchShouldStop_whenClicked_whenItIsRunning() throws Exception {
        SimpleStopwatch stopwatch = new SimpleStopwatch();

        stopwatch.click();
        String text = tapSystemOut(() -> {
            stopwatch.click();
        });

        assertThat(text.trim()).isEqualTo("Stopped");
    }

}
