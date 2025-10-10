package com.waihon.designpatterns.mosh.command.exercise;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class VideoEditorTest {
    private VideoEditor videoEditor;

    @BeforeEach
    void setUp() {
        videoEditor = new VideoEditor();
    }

    @Test
    void canSetText() {
        videoEditor.setText("Hello World!");

        assertThat(videoEditor.getText()).isEqualTo("Hello World!");
    }

    @Test
    void canRemoveText() {
        videoEditor.setText("Hello World!");
        videoEditor.removeText();

        assertThat(videoEditor.getText()).isBlank();
    }

    @Test
    void canSetContrast() {
        videoEditor.setContrast(1.25f);

        assertThat(videoEditor.getContrast()).isEqualTo(1.25f);
    }
}
