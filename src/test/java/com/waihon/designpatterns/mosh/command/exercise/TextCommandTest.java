package com.waihon.designpatterns.mosh.command.exercise;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class TextCommandTest {
    private TextCommand textCommand;
    private String text;
    private VideoEditor videoEditor;

    @BeforeEach
    void setUp() {
        text = "Hello World!";
        videoEditor = new VideoEditor();
        var history = new History();
        textCommand = new TextCommand(text, videoEditor, history);
    }

    @Test
    void canExecute() {
        textCommand.execute();

        assertThat(videoEditor.getText()).isEqualTo(text);
    }

    @Test
    void canUnexecute() {
        textCommand.execute();
        textCommand.unexecute();

        assertThat(videoEditor.getText()).isNull();
    }
}
