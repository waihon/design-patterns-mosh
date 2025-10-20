package com.waihon.designpatterns.mosh.mediator.observer;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.github.stefanbirkner.systemlambda.SystemLambda.tapSystemOut;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class ArticlesDialogBoxTest {
    private ArticlesDialogBox articlesDialogBox;

    @BeforeEach
    void setUp() {
        articlesDialogBox = new ArticlesDialogBox();
    }

    @Test
    void testValidListBoxSelection() throws Exception {
        var text = tapSystemOut(() -> {
            articlesDialogBox.simulateValidListBoxSelection();
        });

        assertThat(text).contains("ArticleListBox: Article 1");
        assertThat(text).contains("TitleTextBox: Article 1");
        assertThat(text).contains("SaveButton: true");
    }

    @Test
    void testEmptyListBoxSelection() throws Exception {
        var text = tapSystemOut(() -> {
            articlesDialogBox.simulateEmptyListBoxSelection();
        });

        assertThat(text).contains("ArticleListBox: ");
        assertThat(text).contains("TitleTextBox: ");
        assertThat(text).contains("SaveButton: false");
    }

    @Test
    void testTextBoxOverridesWithEmptyContent() throws Exception {
        var text = tapSystemOut(() -> {
            articlesDialogBox.simulateTextBoxOverridersWithEmptyContent();
        });

        assertThat(text).contains("ArticleListBox: Article 1");
        assertThat(text).contains("TitleTextBox: ");
        assertThat(text).contains("SaveButton: false");
    }

    @Test
    void testTextBoxOverridesWithNonEmptyContent() throws Exception {
        var text = tapSystemOut(() -> {
            articlesDialogBox.simulateTextBoxOverridersWithNonEmptyContent();
        });

        assertThat(text).contains("ArticleListBox: Article 1");
        assertThat(text).contains("TitleTextBox: Article 2");
        assertThat(text).contains("SaveButton: true");
    }
}
