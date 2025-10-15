package com.waihon.designpatterns.mosh.command.exercise;


public class TextCommand implements UndoableCommand {
    private String newText;
    private VideoEditor videoEditor;
    private History history;
    private String prevText;

    public TextCommand(String newText, VideoEditor videoEditor, History history) {
        this.newText = newText;
        this.videoEditor = videoEditor;
        this.history = history;
    }

    @Override
    public void execute() {
        prevText = videoEditor.getText();
        videoEditor.setText(newText);
        history.push(this);
    }

    @Override
    public void unexecute() {
        videoEditor.setText(prevText);
    }
}
