package com.waihon.designpatterns.mosh.state;

public class OpenCanvas extends Canvas {
    @Override
    public void mouseDown() {
        currentTool.mouseDown();
    }

    @Override
    public void mouseUp() {
        currentTool.mouseUp();
    }
}
