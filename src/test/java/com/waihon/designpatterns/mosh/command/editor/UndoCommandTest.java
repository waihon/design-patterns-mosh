package com.waihon.designpatterns.mosh.command.editor;

import com.waihon.designpatterns.mosh.command.fx.History;
import com.waihon.designpatterns.mosh.command.fx.UndoCommand;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class UndoCommandTest {
    private BoldCommand boldCommand;
    private String content;
    private HtmlDocument document;
    private UndoCommand undoCommand;

    @BeforeEach
    void setUp() {
        document = new HtmlDocument();
        content = "Hello World!";
        document.setContent(content);
        var history = new History();

        boldCommand = new BoldCommand(document, history);
        boldCommand.execute();

        undoCommand = new UndoCommand(history);
    }

    @Test
    void canUnexecute() {
        undoCommand.execute();

        assertThat(document.getContent()).isEqualTo(content);
    }
}
