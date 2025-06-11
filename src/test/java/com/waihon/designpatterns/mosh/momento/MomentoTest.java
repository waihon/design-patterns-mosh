package com.waihon.designpatterns.mosh.momento;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class MomentoTest {
    @Test
    void editorShouldReturnItsContent() {
        Editor editor = new Editor();
        editor.setContent("a");
        assertThat(editor.getContent()).isEqualTo("a");
    }

    @Test
    void editorStateShouldReturnItsContent() {
        EditorState editorState = new EditorState("a");
        assertThat(editorState.getContent()).isEqualTo("a");
    }
}
