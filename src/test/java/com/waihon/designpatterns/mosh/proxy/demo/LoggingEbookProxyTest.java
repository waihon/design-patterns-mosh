package com.waihon.designpatterns.mosh.proxy.demo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static com.github.stefanbirkner.systemlambda.SystemLambda.tapSystemOut;
import static org.assertj.core.api.Assertions.assertThat;

public class LoggingEbookProxyTest {
    private Library library;
    private List<String> fileNames;

    @BeforeEach
    void setUp() {
        library = new Library();
        fileNames = List.of("ebook1.pdf", "Ebook2.pdf", "E-book-3.pdf");
        for (var fileName : fileNames) {
            library.add(new LoggingEbookProxy(fileName));
        }
    }

    @Test
    void openEbooks() throws Exception {
        var text = tapSystemOut(() -> {
            library.openEbook("ebook1.pdf");
            library.openEbook("E-book-3.pdf");
        });

        assertThat(text.lines())
                .containsExactly(
                        "Loading the ebook 'ebook1.pdf'",
                        "Logging the ebook 'ebook1.pdf'",
                        "Showing the ebook 'ebook1.pdf'",
                        "Loading the ebook 'E-book-3.pdf'",
                        "Logging the ebook 'E-book-3.pdf'",
                        "Showing the ebook 'E-book-3.pdf'"
                );
    }
}
