package com.waihon.designpatterns.mosh.state.open;

public class Canvas {

    protected Tool currentTool;

    public void mouseDown() {
        currentTool.mouseDown();
    }

    public void mouseUp() {
        currentTool.mouseUp();
    }

    public Tool getCurrentTool() {
        return currentTool;
    }

    public void setCurrentTool(Tool currentTool) {
        this.currentTool = currentTool;
    }
}