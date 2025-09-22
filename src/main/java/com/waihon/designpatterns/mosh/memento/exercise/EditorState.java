package com.waihon.designpatterns.mosh.memento.exercise;

public class EditorState {
    private final Document document;

    public EditorState(Document document) {
        this.document = new Document(
                document.getContent(),
                document.getFontName(),
                document.getFontSize());
    }

    public Document getDocument() {
        return document;
    }
}
