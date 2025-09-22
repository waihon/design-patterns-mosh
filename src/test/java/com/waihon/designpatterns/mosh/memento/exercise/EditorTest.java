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

    @Test
    void canCreateEditorState() {
        var editorState = editor.createState();
        var editorStateDocument = editorState.getDocument();

        assertThat(document).isEqualTo(editorStateDocument);
    }

    @Test
    void canRestoreState() {
        document.setContent("Content1");
        EditorState state1 = editor.createState();

        document.setContent("Content2");
        EditorState state2 = editor.createState();

        editor.restore(state1);
        assertThat(editor.getDocument()).isEqualTo(state1.getDocument());
    }
}
