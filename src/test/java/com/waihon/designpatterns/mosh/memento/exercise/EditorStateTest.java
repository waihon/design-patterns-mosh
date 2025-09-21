package com.waihon.designpatterns.mosh.memento.exercise;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class EditorStateTest {
    private EditorState editorState;
    private Document originalDocument;

    @BeforeEach
    void setUp() {
        originalDocument = new Document();
        editorState = new EditorState(originalDocument);
    }

    @Test
    void shouldReturnDocument() {
        assertThat(editorState.getDocument()).isEqualTo(originalDocument);
    }
}
