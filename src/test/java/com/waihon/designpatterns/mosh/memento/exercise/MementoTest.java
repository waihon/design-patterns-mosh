package com.waihon.designpatterns.mosh.memento.exercise;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class MementoTest {
    @Test
    void editorCanRestoreState() {
        var editor = new Editor();
        var history = new History();
        var document = new Document();

        editor.setDocument(document);

        document.setContent("first");
        history.push(editor.createState());

        document.setContent("second");
        var state2 = editor.createState();
        history.push(state2);

        document.setContent("third");
        editor.restore(history.pop());
        assertThat(editor.getDocument()).isEqualTo(state2.getDocument());
    }
}
