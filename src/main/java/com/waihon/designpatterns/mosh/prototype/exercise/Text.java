package com.waihon.designpatterns.mosh.prototype.exercise;

public class Text implements Component {
    private String content;

    public Text(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    @Override
    public Component clone() {
        return new Text(this.content);
    }
}
