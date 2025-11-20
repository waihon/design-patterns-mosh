package com.waihon.designpatterns.mosh.builder.exercise;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.github.stefanbirkner.systemlambda.SystemLambda.tapSystemOut;
import static org.assertj.core.api.Assertions.assertThat;

class BuilderTest {
    private Document document;

    @BeforeEach
    void setUp() {
        document = new Document();
        document.add(new Text("Hello, World!"));
        document.add(new Image("pic1.jpg"));
    }

    @Test
    void exportToHtmlFormat() throws Exception {
        var text = tapSystemOut(() -> {
            document.export(new HtmlDocumentBuilder(), "export.html");
        });

        assertThat(text.lines()).containsExactly("<html><p>Hello, World!</p><img src=\"pic1.jpg\" /></html>");
    }

    @Test
    void exportToTextFormat() throws Exception {
        var text = tapSystemOut(() -> {
            document.export(new TextDocumentBuilder(), "export.txt");
        });

        assertThat(text.lines()).containsExactly("Hello, World!");
    }
}
