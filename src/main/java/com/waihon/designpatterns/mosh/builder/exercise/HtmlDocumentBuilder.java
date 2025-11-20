package com.waihon.designpatterns.mosh.builder.exercise;

import com.waihon.designpatterns.mosh.builder.exercise.html.HtmlDocument;
import com.waihon.designpatterns.mosh.builder.exercise.html.HtmlImage;
import com.waihon.designpatterns.mosh.builder.exercise.html.HtmlParagraph;

public class HtmlDocumentBuilder implements DocumentBuilder {
    private HtmlDocument document = new HtmlDocument();

    @Override
    public void addElement(Element element) {
        if (element instanceof Text) {
            var text = ((Text)element).getContent();
            document.add(new HtmlParagraph(text));
        }
        else if (element instanceof Image) {
            var source = ((Image)element).getSource();
            document.add(new HtmlImage(source));
        }
    }

    public HtmlDocument getHtmlDocument() {
        return document;
    }

    @Override
    public String toString() {
        return document.toString();
    }
}
