package com.waihon.designpatterns.mosh.builder.demo;

import java.util.ArrayList;
import java.util.List;

public class Presentation {
    private List<Slide> slides = new ArrayList<>();

    public void addSlide(Slide slide) {
        slides.add(slide);
    }

    public void export(PresentationFormat format) {
        if (format == PresentationFormat.PDF) {
            var pdf = new PdfDocument();
            for (var slide : slides) {
                pdf.addPage((slide.getText()));
            }
        } else if (format == PresentationFormat.MOVIE) {
            var movie = new Movie();
            for (var slide : slides) {
                movie.addFrame(slide.getText(), 3);
            }
        }
    }
}
