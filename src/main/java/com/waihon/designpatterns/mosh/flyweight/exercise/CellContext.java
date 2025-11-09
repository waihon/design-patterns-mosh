package com.waihon.designpatterns.mosh.flyweight.exercise;

import java.util.Objects;

public class CellContext {
    // These are the attributes that can be shared in many cells.
    // That's why they have been encapsulated inside this class.
    // The CellContextFactory class will ensure that every combination
    // of these attributes will only be stoed once.
    private final String fontFamily;
    private final int fontSize;
    private final boolean bold;

    public CellContext(String fontFamily, int fontSize, boolean bold) {
        this.fontFamily = fontFamily;
        this.fontSize = fontSize;
        this.bold = bold;
    }

    public String getFontFamily() {
        return fontFamily;
    }

    public int getFontSize() {
        return fontSize;
    }

    public boolean isBold() {
        return bold;
    }

    @Override
    public int hashCode() {
        return Objects.hash(fontFamily, fontSize, bold);
    }
}
