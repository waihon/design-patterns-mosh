package com.waihon.designpatterns.mosh.command.exercise;

import com.waihon.designpatterns.mosh.command.fx.History;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class ContrastCommandTest {
    private float newContrast;
    private VideoEditor videoEditor;
    private ContrastCommand contrastCommand;

    @BeforeEach
    void setUp() {
        newContrast = 2.5f;
        videoEditor = new VideoEditor();
        var history = new History();
        contrastCommand = new ContrastCommand(newContrast, videoEditor, history);
    }

    @Test
    void canExecute() {
       contrastCommand.execute();

       assertThat(videoEditor.getContrast()).isEqualTo(2.5f);
    }

    @Test
    void canUnexecute() {
        contrastCommand.execute();
        assertThat(videoEditor.getContrast()).isEqualTo(2.5f);

        contrastCommand.unexecute();
        assertThat(videoEditor.getContrast()).isEqualTo(0.5f);
    }
}
