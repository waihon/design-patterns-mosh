package com.waihon.designpatterns.mosh.state.open;

public abstract class Canvas {

    protected Tool currentTool;

    public abstract void mouseDown();

    public abstract void mouseUp();

    public Tool getCurrentTool() {
        return currentTool;
    }

    public void setCurrentTool(Tool currentTool) {
        this.currentTool = currentTool;
    }
}