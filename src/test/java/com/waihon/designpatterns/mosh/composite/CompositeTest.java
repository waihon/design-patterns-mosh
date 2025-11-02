package com.waihon.designpatterns.mosh.composite;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.regex.Pattern;

import static com.github.stefanbirkner.systemlambda.SystemLambda.tapSystemOut;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class CompositeTest {
    private Group group1;
    private Group group2;
    private Group group;

    private Shape shape1;
    private Shape shape2;
    private Shape shape3;
    private Shape shape4;

    private final String RENDER_MESSAGE = "Render Shape";
    private final String MOVE_MESSAGE = "Move Shape";

    @BeforeEach
    void setUp() {
        group1 = new Group();
        group1.add(shape1 = new Shape());
        group1.add(shape2 = new Shape());

        group2 = new Group();
        group2.add(shape3 = new Shape());
        group2.add(shape4 = new Shape());

        group = new Group();
        group.add(group1);
        group.add(group2);
    }

    @Test
    void renderAShape() throws Exception {
        var text = tapSystemOut(() -> {
            shape1.render();
        });

        assertThat(text).contains(RENDER_MESSAGE);
        var count = countOfSubstring(text, RENDER_MESSAGE);
        assertThat(count).isEqualTo(1);
    }

    @Test
    void renderAGroupOfTwoShapes() throws Exception {
        var text = tapSystemOut(() -> {
            group1.render();
        });

        assertThat(text).contains(RENDER_MESSAGE);
        var count = countOfSubstring(text, RENDER_MESSAGE);
        assertThat(count).isEqualTo(2);
    }

    @Test
    void renderTwoGroupsOfTwoShapesEach () throws Exception {
        var text = tapSystemOut(() -> {
            group.render();
        });

        assertThat(text).contains(RENDER_MESSAGE);
        var count = countOfSubstring(text, RENDER_MESSAGE);
        assertThat(count).isEqualTo(4);
    }

    private int countOfSubstring(String string, String substring) {
        return string.split(Pattern.quote(substring), -1).length - 1;
    }
}
