package com.waihon.designpatterns.mosh.visitor;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.github.stefanbirkner.systemlambda.SystemLambda.tapSystemOut;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class VisitorTest {
    private HtmlDocument document;

    @BeforeEach
    void setUp() {
        document = new HtmlDocument();
        document.add(new HeadingNode());
        document.add(new AnchorNode());
    }

    @Test
    void testHighlightOperation() throws Exception {
        var text = tapSystemOut(() -> {
            document.execute(new HighlightOperation());
        });

        assertThat(text).contains("highlight-heading");
        assertThat(text).contains("highlight-anchor");
    }

    @Test
    void testPlainTextOperation() throws Exception {
        var text = tapSystemOut(() -> {
            document.execute(new PlainTextOperation());
        });

        assertThat(text).contains("plaintext-heading");
        assertThat(text).contains("plaintext-anchor");
    }
}
