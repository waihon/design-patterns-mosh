package com.waihon.designpatterns.mosh.visitor.exercise;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.regex.Pattern;

import static com.github.stefanbirkner.systemlambda.SystemLambda.tapSystemOut;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class VisitorTest {
    private WavFile wavFile;

    @BeforeEach
    void setUp() {
        wavFile = new WavFile();
        wavFile.add(new FormatSegment());
        wavFile.add(new FactSegment());
        wavFile.add(new FormatSegment());
        wavFile.add(new FactSegment());
        wavFile.add(new FormatSegment());
    }

    @Test
    void testReduceNoiseOperation() throws Exception {
        var text = tapSystemOut(() -> {
            wavFile.execute(new ReduceNoiseOperation());
        });

        var message1 = "Reduce Noise: Format Segment";
        var count1 = text.split(Pattern.quote(message1), -1).length - 1;
        assertThat(text).contains(message1);
        assertThat(count1).isEqualTo(3);

        var message2 = "Reduce Noise: Fact Segment";
        var count2 = text.split(Pattern.quote(message2), -1).length - 1;
        assertThat(text).contains(message2);
        assertThat(count2).isEqualTo(2);
    }

    @Test
    void testAddReverbOperation() throws Exception {
        var text = tapSystemOut(() -> {
            wavFile.execute(new AddReverbOperation());
        });

        var message1 = "Add Reverb: Format Segment";
        var count1 = text.split(Pattern.quote(message1), -1).length - 1;
        assertThat(text).contains(message1);
        assertThat(count1).isEqualTo(3);

        var message2 = "Add Reverb: Fact Segment";
        var count2 = text.split(Pattern.quote(message2), -1).length - 1;
        assertThat(text).contains(message2);
        assertThat(count2).isEqualTo(2);
    }

    @Test
    void testNormalizeOperation() throws Exception {
        var text = tapSystemOut(() -> {
            wavFile.execute(new NormalizeOperation());
        });

        var message1 = "Normalize: Format Segment";
        var count1 = text.split(Pattern.quote(message1), -1).length - 1;
        assertThat(text).contains(message1);
        assertThat(count1).isEqualTo(3);

        var message2 = "Normalize: Fact Segment";
        var count2 = text.split(Pattern.quote(message2), -1).length - 1;
        assertThat(text).contains(message2);
        assertThat(count2).isEqualTo(2);
    }
}
