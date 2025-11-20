package com.waihon.designpatterns.mosh.builder.exercise;

public interface DocumentBuilder {
    void addText(Text text);
    void addImage(Image image);
    String getResult();
}
