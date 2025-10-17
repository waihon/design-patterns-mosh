package com.waihon.designpatterns.mosh.command.exercise;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class UndoCommandTest {
    private TextCommand textCommand;
    private TextCommand textCommand2;
    private ContrastCommand contrastCommand;
    private ContrastCommand contrastCommand2;
    private final String DEFAULT_TEXT = null;
    private String newText;
    private String newText2;
    private final float DEFAULT_CONTRAST = 0.5f;
    private float newContrast;
    private float newContrast2;
    private VideoEditor videoEditor;
    private UndoCommand undoCommand;

    @BeforeEach
    void setUp() {
        videoEditor = new VideoEditor();
        newText = "Hello World";
        newText2 = "Apa Khabar Dunie";
        newContrast = 3.0f;
        newContrast2 = 4.0f;
        var history = new History();

        textCommand = new TextCommand(newText, videoEditor, history);
        textCommand2 = new TextCommand(newText2, videoEditor, history);
        contrastCommand = new ContrastCommand(newContrast, videoEditor, history);
        contrastCommand2 = new ContrastCommand(newContrast2, videoEditor, history);
        undoCommand = new UndoCommand(history);
    }

    @Test
    void executeAndUndoTextCommand() {
        assertThat(videoEditor.getText()).isEqualTo(DEFAULT_TEXT);

        textCommand.execute();
        assertThat(videoEditor.getText()).isEqualTo(newText);

        undoCommand.execute();
        assertThat(videoEditor.getText()).isNull();
    }

    @Test
    void executeAndUndocontrastCommand() {
        assertThat(videoEditor.getContrast()).isEqualTo(0.5f);

        contrastCommand.execute();
        assertThat(videoEditor.getContrast()).isEqualTo(newContrast);

        undoCommand.execute();
        assertThat(videoEditor.getContrast()).isEqualTo(0.5f);
    }

    @Test
    void executeMultipleTextCommandAndUndoLastOne() {
        assertThat(videoEditor.getText()).isNull();

        textCommand.execute();
        assertThat(videoEditor.getText()).isEqualTo(newText);

        textCommand2.execute();
        assertThat(videoEditor.getText()).isEqualTo(newText2);

        undoCommand.execute();
        assertThat(videoEditor.getText()).isEqualTo(newText);
    }

    @Test
    void executeMultipleTextCommandAndUndoAll() {
        assertThat(videoEditor.getText()).isNull();

        textCommand.execute();
        assertThat(videoEditor.getText()).isEqualTo(newText);

        textCommand2.execute();
        assertThat(videoEditor.getText()).isEqualTo(newText2);

        undoCommand.execute();
        assertThat(videoEditor.getText()).isEqualTo(newText);

        undoCommand.execute();
        assertThat(videoEditor.getText()).isNull();
    }

    @Test
    void executeMultipleContrastCommandAndUndoLastOne() {
        assertThat(videoEditor.getContrast()).isEqualTo(0.5f);

        contrastCommand.execute();
        assertThat(videoEditor.getContrast()).isEqualTo(3.0f);

        contrastCommand2.execute();
        assertThat(videoEditor.getContrast()).isEqualTo(4.0f);

        undoCommand.execute();
        assertThat(videoEditor.getContrast()).isEqualTo(3.0f);
    }

    @Test
    void executeMultipleContrastCommandAndUndoAll() {
        assertThat(videoEditor.getContrast()).isEqualTo(0.5f);

        contrastCommand.execute();
        assertThat(videoEditor.getContrast()).isEqualTo(3.0f);

        contrastCommand2.execute();
        assertThat(videoEditor.getContrast()).isEqualTo(4.0f);

        undoCommand.execute();
        assertThat(videoEditor.getContrast()).isEqualTo(3.0f);

        undoCommand.execute();
        assertThat(videoEditor.getContrast()).isEqualTo(0.5f);
    }

    @Test
    void executeMultipleCommandOfDifferentTypeAndUndoLastTwo() {
        assertThat(videoEditor.getText()).isEqualTo(DEFAULT_TEXT);
        assertThat(videoEditor.getContrast()).isEqualTo(DEFAULT_CONTRAST);

        textCommand.execute();
        assertThat(videoEditor.getText()).isEqualTo(newText);

        contrastCommand.execute();
        assertThat(videoEditor.getContrast()).isEqualTo(newContrast);

        textCommand2.execute();
        assertThat(videoEditor.getText()).isEqualTo(newText2);

        contrastCommand2.execute();
        assertThat(videoEditor.getContrast()).isEqualTo(newContrast2);

        undoCommand.execute();
        undoCommand.execute();
        assertThat(videoEditor.getText()).isEqualTo(newText);
        assertThat(videoEditor.getContrast()).isEqualTo(newContrast);
    }
}
