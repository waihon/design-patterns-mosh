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
}
