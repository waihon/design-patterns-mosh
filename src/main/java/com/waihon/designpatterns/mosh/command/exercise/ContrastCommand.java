package com.waihon.designpatterns.mosh.command.exercise;

import com.waihon.designpatterns.mosh.command.fx.History;
import com.waihon.designpatterns.mosh.command.fx.UndoableCommand;

public class ContrastCommand implements UndoableCommand {
    private float prevContrast;
    private float newContrast;
    private VideoEditor videoEditor;
    private History history;

    public ContrastCommand(float newContrast, VideoEditor videoEditor, History history) {
        this.newContrast = newContrast;
        this.videoEditor = videoEditor;
        this.history = history;
    }

    public void execute() {
        prevContrast = videoEditor.getContrast();
        videoEditor.setContrast(newContrast);
        history.push(this);
    }

    public void unexecute() {
        videoEditor.setContrast(prevContrast);
    }
}
