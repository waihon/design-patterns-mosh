package com.waihon.designpatterns.mosh.memento.exercise;

public class EditorState {
    private final Document document;

    public EditorState(Document document) {
        this.document = document;
    }

    public Document getDocument() {
        return document;
    }
}
