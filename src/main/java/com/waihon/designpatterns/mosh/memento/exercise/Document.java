package com.waihon.designpatterns.mosh.memento.exercise;

import java.util.Objects;

public class Document {
    private String content;
    private String fontName;
    private int fontSize;

    public Document() {
        this.content = "";
        this.fontName = "Courier New";
        this.fontSize = 11;
    }

    public Document(String content, String fontName, int fontSize) {
        this.content = content;
        this.fontName = fontName;
        this.fontSize = fontSize;
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

    @Override
    public boolean equals(Object other) {
        if (other == null || getClass() != other.getClass()) return false;
        Document document = (Document) other;
        return fontSize == document.fontSize &&
                Objects.equals(content, document.content) &&
                Objects.equals(fontName, document.fontName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(content, fontName, fontSize);
    }

    @Override
    public String toString() {
        return "Document{" +
                "content='" + content + '\'' +
                ", fontName='" + fontName + '\'' +
                ", fontSize=" + fontSize +
                '}';
    }
}
