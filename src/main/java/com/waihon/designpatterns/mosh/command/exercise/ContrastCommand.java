package com.waihon.designpatterns.mosh.command.exercise;

import com.waihon.designpatterns.mosh.command.fx.History;
import com.waihon.designpatterns.mosh.command.fx.UndoableCommand;

public class ContrastCommand extends AbstractUndoableCommand {
    private float prevContrast;
    private float newContrast;

    public ContrastCommand(float newContrast, VideoEditor videoEditor, History history) {
        super(videoEditor, history);

        this.newContrast = newContrast;
    }

    @Override
    protected void doExecute() {
        prevContrast = videoEditor.getContrast();

        videoEditor.setContrast(newContrast);
    }

    @Override
    public void undo() {
        videoEditor.setContrast(prevContrast);
    }
}
