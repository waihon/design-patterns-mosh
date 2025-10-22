package com.waihon.designpatterns.mosh.memento.solution;

public class DocumentMemento {
    private String content;
    private String fontName;
    private int fontSize;

    public DocumentMemento(String content, String fontName, int fontSize) {
        this.content = content;
        this.fontName = fontName;
        this.fontSize = fontSize;
    }

    public String getContent() {
        return this.content;
    }

    public String getFontName() {
        return fontName;
    }

    public int getFontSize() {
        return fontSize;
    }
}
