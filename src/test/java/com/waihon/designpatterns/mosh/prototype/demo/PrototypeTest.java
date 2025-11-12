package com.waihon.designpatterns.mosh.prototype.demo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.github.stefanbirkner.systemlambda.SystemLambda.tapSystemOut;
import static org.assertj.core.api.Assertions.assertThat;

class PrototypeTest {
    private ContextMenu menu;
    private Circle circle;
    private final int RADIUS = 15;
    @BeforeEach
    void setUp() {
        menu = new ContextMenu();
        circle = new Circle();
        circle.setRadius(RADIUS);
    }

    @Test
    void cloneCircle() throws Exception {
        var newCircle = (Circle) menu.duplicate(circle);

        assertThat(newCircle.getRadius()).isEqualTo(RADIUS);
    }

    @Test
    void renderCircle() throws Exception {
        var text = tapSystemOut(() -> {
            circle.render();
        });

        assertThat(text.lines())
                .containsExactly("Rendering a circle with a radius of " + RADIUS + "...");
    }
}
