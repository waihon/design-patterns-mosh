package com.waihon.designpatterns.mosh.builder.demo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.github.stefanbirkner.systemlambda.SystemLambda.tapSystemOut;
import static org.assertj.core.api.Assertions.assertThat;

class BuilderTest {
    private Presentation presentation;
    private Slide slide1;
    private Slide slide2;
    private Slide slide3;

    @BeforeEach
    void setUp() {
        presentation = new Presentation();
        slide1 = new Slide("Slide 1");
        slide2 = new Slide("Slide 2");
        slide3 = new Slide("Slide 3");
        presentation.addSlide(slide1);
        presentation.addSlide(slide2);
        presentation.addSlide(slide3);
    }

    @Test
    void exportPresentationToPdf() throws Exception {
        var text = tapSystemOut(() -> {
            presentation.export(PresentationFormat.PDF);
        });

        assertThat(text.lines())
                .containsExactly(
                        "Adding a page to PDF: Slide 1",
                        "Adding a page to PDF: Slide 2",
                        "Adding a page to PDF: Slide 3"
                );
    }

    @Test
    void exportPresentationToMovie() throws Exception {
        var text = tapSystemOut(() -> {
            presentation.export(PresentationFormat.MOVIE);
        });

        assertThat(text.lines())
                .containsExactly(
                        "Adding a frame to the movie: Slide 1 [3]",
                        "Adding a frame to the movie: Slide 2 [3]",
                        "Adding a frame to the movie: Slide 3 [3]"
                );
    }
}
