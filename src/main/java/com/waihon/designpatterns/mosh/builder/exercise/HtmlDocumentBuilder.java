package com.waihon.designpatterns.mosh.builder.exercise;

import com.waihon.designpatterns.mosh.builder.exercise.html.HtmlDocument;
import com.waihon.designpatterns.mosh.builder.exercise.html.HtmlImage;
import com.waihon.designpatterns.mosh.builder.exercise.html.HtmlParagraph;

public class HtmlDocumentBuilder implements DocumentBuilder {
    private HtmlDocument document = new HtmlDocument();

    @Override
    public void addText(Text text) {
        document.add(new HtmlParagraph(text.getContent()));
    }

    @Override
    public void addImage(Image image) {
        document.add(new HtmlImage(image.getSource()));
    }

    @Override
    public String getResult() {
        return document.toString();
    }
}
