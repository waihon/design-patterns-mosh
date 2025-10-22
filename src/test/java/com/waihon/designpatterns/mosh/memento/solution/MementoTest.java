package com.waihon.designpatterns.mosh.memento.solution;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.github.stefanbirkner.systemlambda.SystemLambda.tapSystemOut;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class MementoTest {
    private Document document;
    private History history;

    @BeforeEach
    void setUp() {
        document = new Document();
        history = new History();
    }

    @Test
    void testMementoPattern() throws Exception {
        document.setContent("Hello");
        history.push(document.createMemento());  // Hello, null, 0
        document.setFontName("Font 1");
        history.push(document.createMemento());  // Hello, Font 1, 0
        document.setFontSize(10);                // Hello, Font 1, 10

        var text = tapSystemOut(() -> {
            System.out.println(document);
        });

        assertThat(text).contains("Document{content='Hello', fontName='Font 1', fontSize=10}");

        document.restore(history.pop());

        text = tapSystemOut(() -> {
            System.out.println(document);
        });

        assertThat(text).contains("Document{content='Hello', fontName='Font 1', fontSize=0}");

        document.restore(history.pop());

        text = tapSystemOut(() -> {
            System.out.println(document);
        });

        assertThat(text).contains("Document{content='Hello', fontName='null', fontSize=0}");
    }
}
