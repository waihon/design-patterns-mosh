package com.waihon.designpatterns.mosh.flyweight.demo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.github.stefanbirkner.systemlambda.SystemLambda.tapSystemOut;
import static org.assertj.core.api.Assertions.assertThat;

class FlyweightTest {
    private PointService service;

    @BeforeEach
    void setUp() {
        service = new PointService(new PointIconFactory());
    }

    @Test
    void drawPoints() throws Exception {
        var text = tapSystemOut(() -> {
            for (var point : service.getPoints()) {
                point.draw();
            }
        });

        assertThat(text.lines())
                .containsExactly(
                        "CAFE at (1, 2)",
                        "HOSPITAL at (3, 8)",
                        "RESTAURANT at (7, 15)"
                );
    }
}
