package com.waihon.designpatterns.mosh.builder.exercise;

import com.waihon.designpatterns.mosh.builder.exercise.text.TextDocument;

public class TextDocumentBuilder implements DocumentBuilder {
    private TextDocument document = new TextDocument();

    @Override
    public void addText(Text text) {
        document.append(text.getContent());
    }

    @Override
    public void addImage(Image image) {
        // Images are not applicable to Text document.
    }

    @Override
    public String getResult() {
        return document.toString();
    }
}
