package com.waihon.designpatterns.mosh.command.editor;

import com.waihon.designpatterns.mosh.command.fx.History;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class BoldCommandTest {
    private BoldCommand boldCommand;
    private String content;
    private HtmlDocument document;

    @BeforeEach
    void setUp() {
        document = new HtmlDocument();
        content = "Hello World!";
        document.setContent(content);
        var history = new History();
        boldCommand = new BoldCommand(document, history);
    }

    @Test
    void canExecute() {
        boldCommand.execute();

        assertThat(document.getContent()).isEqualTo("<b>" + content + "</b>");
    }

    @Test
    void canUnexecute() {
        boldCommand.execute();
        boldCommand.unexecute();

        assertThat(document.getContent()).isEqualTo(content);
    }
}
