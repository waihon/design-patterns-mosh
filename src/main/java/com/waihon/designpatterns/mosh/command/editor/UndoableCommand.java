package com.waihon.designpatterns.mosh.command.editor;

public interface UndoableCommand extends Command {
    void unexecute();
}
