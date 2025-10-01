package com.waihon.designpatterns.mosh.command.editor;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class HtmlDocumentTest {
    private HtmlDocument htmlDocument;
    private String content;

    @BeforeEach
    void setUp() {
        htmlDocument = new HtmlDocument();
        content = "Hello World!";
        htmlDocument.setContent(content);
    }

    @Test
    void canGetContent() {
       assertThat(htmlDocument.getContent()).isEqualTo(content);
    }

    @Test
    void canMakeContentBold() {
        htmlDocument.makeBold();

        assertThat(htmlDocument.getContent()).isEqualTo("<b>" + content + "</b>");
    }
}
