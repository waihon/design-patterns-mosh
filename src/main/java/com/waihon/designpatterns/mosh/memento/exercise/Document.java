package com.waihon.designpatterns.mosh.memento.exercise;

public class Document {
    private String content;
    private String fontName;
    private int fontSize;

    public Document() {
        this.content = "";
        this.fontName = "Courier New";
        this.fontSize = 11;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getFontName() {
        return fontName;
    }

    public void setFontName(String fontName) {
        this.fontName = fontName;
    }

    public int getFontSize() {
        return fontSize;
    }

    public void setFontSize(int fontSize) {
        this.fontSize = fontSize;
    }
}
