package com.waihon.designpatterns.mosh.command.editor;

import com.waihon.designpatterns.mosh.command.fx.History;
import com.waihon.designpatterns.mosh.command.fx.UndoableCommand;

public class BoldCommand implements UndoableCommand {
    private String prevContent;
    private HtmlDocument document;
    private History history;

    public BoldCommand(HtmlDocument document, History history) {
        this.document = document;
        this.history = history;
    }

    @Override
    public void execute() {
        prevContent = document.getContent();
        document.makeBold();
        history.push(this);
    }

    public void undo() {
        document.setContent(prevContent);
    }
}
