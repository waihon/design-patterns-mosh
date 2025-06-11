package com.waihon.designpatterns.mosh.momento;

public class Editor {
    private String content;

    public EditorState createState() {
        return new EditorState(content);
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
