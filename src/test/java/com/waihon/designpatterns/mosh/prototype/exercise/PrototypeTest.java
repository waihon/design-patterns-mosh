package com.waihon.designpatterns.mosh.prototype.exercise;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PrototypeTest {
    private Timeline timeline;
    private ContextMenu menu;
    private Audio audio;
    private Clip clip;
    private Text text;

    @BeforeEach
    void setUp() {
        timeline = new Timeline();
        menu = new ContextMenu(timeline);
        audio = new Audio(128);
        clip = new Clip(30);
        text = new Text("Hello, World!");
    }

    @Test
    void addComponentsToTimeline() {
        assertThat(timeline.getComponents().size()).isEqualTo(0);

        timeline.add(audio);
        timeline.add(clip);
        timeline.add(text);

        assertThat(timeline.getComponents().size()).isEqualTo(3);
    }

    @Test
    void timelineDuplicatesComponents() {
        timeline.add(audio);
        timeline.add(clip);
        timeline.add(text);

        menu.duplicate(clip);
        menu.duplicate(audio);
        menu.duplicate(text);

        assertThat(timeline.getComponents().size()).isEqualTo(6);
    }
}
