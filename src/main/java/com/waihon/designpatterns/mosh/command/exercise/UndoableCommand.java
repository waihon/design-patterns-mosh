package com.waihon.designpatterns.mosh.command.exercise;

import com.waihon.designpatterns.mosh.command.editor.Command;

public interface UndoableCommand extends Command {
    void unexecute();
}
