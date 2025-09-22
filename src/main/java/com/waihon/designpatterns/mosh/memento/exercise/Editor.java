package com.waihon.designpatterns.mosh.memento.exercise;

public class Editor {
    private Document document;

    public Document getDocument() {
        return document;
    }

    public void setDocument(Document document) {
        this.document = document;
    }

    public EditorState createState() {
        return new EditorState(document);
    }

    public void restore(EditorState state) {
        this.document = state.getDocument();
    }
}
