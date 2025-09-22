package com.waihon.designpatterns.mosh.memento.exercise;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Nested;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class HistoryTest {
    private History history;

    @BeforeEach
    void setUp() {
        history = new History();
    }

    @Nested
    class emptyHistory {
        @Test
        void shouldHaveSizeofZero() {
            assertThat(history.getSize()).isEqualTo(0);
        }

        @Test
        void shouldIncreaseSizeWhenPushed() {
            history.push(new EditorState(new Document()));

            assertThat(history.getSize()).isEqualTo(1);
        }

        @Test
        void shouldReturnNullWhenPopped() {
            EditorState lastState = history.pop();

            assertThat(history.pop()).isEqualTo(null);
        }
    }

    @Nested
    class nonEmptyHistory {
        private Document document;
        private EditorState state1;
        private EditorState state2;

        @BeforeEach
        void setUp() {
            document = new Document();
            document.setContent("Content1");
            state1 = new EditorState(document);
            history.push(state1);

            document.setContent("Content2");
            state2 = new EditorState(document);
            history.push(state2);
        }

        @Test
        void shouldHavePositiveSize() {
            assertThat(history.getSize()).isEqualTo(2);
        }

        @Test
        void shouldReturnLastStateWhenPopped() {
            EditorState state = history.pop();

            assertThat(state.getDocument()).isEqualTo(state2.getDocument());
            assertThat(history.getSize()).isEqualTo(1);
        }
    }
}
