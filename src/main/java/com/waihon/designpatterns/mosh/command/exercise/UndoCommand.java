package com.waihon.designpatterns.mosh.command.exercise;

import com.waihon.designpatterns.mosh.command.fx.Command;
import com.waihon.designpatterns.mosh.command.fx.History;

public class UndoCommand implements Command {
    private History history;

    public UndoCommand(History history) {
        this.history = history;
    }

    @Override
    public void execute() {
        if (history.size() > 0) {
            history.pop().unexecute();
        }
    }
}
