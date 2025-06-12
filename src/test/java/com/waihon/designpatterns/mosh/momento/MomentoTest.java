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

    @Test
    void editorCanCreateState() {
        Editor editor = new Editor();
        editor.setContent("a");
        EditorState editorState = editor.createState();
        assertThat(editorState.getContent()).isEqualTo("a");
    }

    @Test
    void editorCanRestoreState() {
        Editor editor = new Editor();
        editor.setContent("a");
        assertThat(editor.getContent()).isEqualTo("a");
        EditorState stateA = editor.createState();

        editor.setContent("b");
        assertThat(editor.getContent()).isEqualTo("b");

        editor.restore(stateA);
        assertThat(editor.getContent()).isEqualTo("a");
    }

    @Test
    void historyHasSize() {
        History history = new History();
        assertThat(history.getSize()).isEqualTo(0);
    }
}
