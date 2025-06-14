package com.waihon.designpatterns.mosh.state.abuse;

import org.junit.jupiter.api.Test;

import static com.github.stefanbirkner.systemlambda.SystemLambda.tapSystemOut;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class StopwatchTest {

    @Test
    void stopwatchShouldRun_whenClicked_whenItIsStoped() throws Exception {
        Stopwatch stopwatch = new Stopwatch();

        String text = tapSystemOut(() -> {
            stopwatch.click();
        });

        assertThat(text.trim()).isEqualTo("Running");
    }

}
