package com.waihon.designpatterns.mosh.command.fx;

import java.util.ArrayDeque;
import java.util.Deque;
import com.waihon.designpatterns.mosh.command.fx.UndoableCommand;

public class History {
    private Deque<UndoableCommand> commands = new ArrayDeque<>();

    public void push(UndoableCommand command) {
        commands.push(command);
    }

    public UndoableCommand pop() {
        return commands.pop();
    }

    public int size() {
        return commands.size();
    }
}
