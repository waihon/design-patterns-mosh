package com.waihon.designpatterns.mosh.memento.exercise;

public class Editor {
    private Document document;

    public Document getDocument() {
        return document;
    }

    public void setDocument(Document document) {
        this.document = document;
    }

    public EditorState createEditorState() {
        var documentSnapshot = new Document(
                document.getContent(),
                document.getFontName(),
                document.getFontSize());

        return new EditorState(documentSnapshot);
    }
}
