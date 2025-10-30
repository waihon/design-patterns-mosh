package com.waihon.designpatterns.mosh.command.exercise;

import com.waihon.designpatterns.mosh.command.fx.History;
import com.waihon.designpatterns.mosh.command.fx.UndoableCommand;

public class TextCommand extends AbstractUndoableCommand {
    private String newText;
    private String prevText;

    public TextCommand(String newText, VideoEditor videoEditor, History history) {
        super(videoEditor, history);

        this.newText = newText;
    }

    @Override
    protected void doExecute() {
        prevText = videoEditor.getText();

        videoEditor.setText(newText);
    }

    @Override
    public void undo() {
        videoEditor.setText(prevText);
    }
}
