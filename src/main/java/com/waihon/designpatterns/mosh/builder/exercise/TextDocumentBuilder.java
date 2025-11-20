package com.waihon.designpatterns.mosh.builder.exercise;

import com.waihon.designpatterns.mosh.builder.exercise.text.TextDocument;

public class TextDocumentBuilder implements DocumentBuilder {
    private TextDocument document = new TextDocument();

    @Override
    public void addElement(Element element) {
        if (element instanceof Text) {
            var text = ((Text)element).getContent();
            document.append(text);
        }
    }

    public TextDocument getTextDocument() {
        return document;
    }

    @Override
    public String toString() {
        return document.toString();
    }
}
