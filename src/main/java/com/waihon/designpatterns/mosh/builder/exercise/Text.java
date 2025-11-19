package com.waihon.designpatterns.mosh.builder.exercise;

public class Text implements Element {
    private String content;

    public Text(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }
}
