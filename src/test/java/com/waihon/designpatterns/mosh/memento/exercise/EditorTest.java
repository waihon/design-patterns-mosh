package com.waihon.designpatterns.mosh.memento.exercise;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class EditorTest {
    private Editor editor;
    private Document document;

    @BeforeEach
    void setUp() {
        editor = new Editor();
        document = new Document();
        editor.setDocument(document);
    }

    @Test
    void shouldReturnDocument() {
        var editorDocument = editor.getDocument();

        assertThat(editorDocument).isEqualTo(document);
    }
}
