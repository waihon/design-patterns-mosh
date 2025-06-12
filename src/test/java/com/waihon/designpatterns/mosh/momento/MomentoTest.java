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

    @Test
    void historyShouldIncreaseSizeWhenPushed() {
        History history = new History();
        history.push(new EditorState("content"));
        assertThat(history.getSize()).isEqualTo(1);
    }

    @Test
    void histroyShouldReturnLastEditorStateWhenPopped() {
        History history = new History();
        history.push(new EditorState("first"));
        history.push(new EditorState("second"));
        assertThat(history.getSize()).isEqualTo(2);

        EditorState state = history.pop();
        assertThat(state.getContent()).isEqualTo("second");
        assertThat(history.getSize()).isEqualTo(1);
    }

    @Test
    void emptyHistoryShouldReturnNullWhenPopped() {
        History history = new History();
        EditorState lastState = history.pop();
        assertThat(history.pop()).isEqualTo(null);
    }

    @Test
    void testMomentoDesignPattern() {
        var editor = new Editor();
        var history = new History();

        editor.setContent("first");
        history.push(editor.createState());

        editor.setContent("second");
        history.push(editor.createState());

        editor.setContent("third");
        editor.restore(history.pop());
        assertThat(editor.getContent()).isEqualTo("second");
    }
}
