package com.waihon.designpatterns.mosh.momento;

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
}
