package com.waihon.designpatterns.mosh.memento.exercise;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class DocumentTest {
    private Document document;

    @BeforeEach
    void setUp() {
        document = new Document();
    }

    @Test
    void shouldHaveBlankContentByDefault() {
        assertThat(document.getContent()).isEmpty();
    }

    @Test
    void shouldHaveDefaultFontName() {
        assertThat(document.getFontName()).isEqualTo("Courier New");
    }

    @Test
    void shouldHaveDefaultFontSize() {
        assertThat(document.getFontSize()).isEqualTo(11);
    }

    @Test
    void equalityTest() {
        var document1 = new Document();
        var document2 = new Document();

        assertThat(document1).isEqualTo(document2);
    }

    @Test
    void inequalityTest() {
        var document1 = new Document();
        var document2 = new Document();

        document1.setFontName("Helvatica");
        document2.setFontName("Menlo");

        assertThat(document1).isNotEqualTo(document2);
    }
}
