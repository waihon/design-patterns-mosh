package com.waihon.designpatterns.mosh.memento.exercise;

import java.util.ArrayList;
import java.util.List;

public class History {
    private List<EditorState> states = new ArrayList<>();

    public int getSize() {
        return states.size();
    }

    public void push(EditorState state) {
        states.add(state);
    }

    public EditorState pop() {
        if (getSize() < 1) {
            return null;
        }

        var lastIndex = getSize() - 1;
        var lastState = states.get(lastIndex);
        states.remove(lastState);

        return lastState;
    }
}
