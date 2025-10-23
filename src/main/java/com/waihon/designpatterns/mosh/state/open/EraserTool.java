package com.waihon.designpatterns.mosh.state.open;

public class EraserTool implements Tool {

    private Canvas canvas;

    public EraserTool(Canvas canvas) {
        this.canvas = canvas;
    }

    @Override
    public void mouseDown() {
        System.out.println("Eraser icon");
    }

    @Override
    public void mouseUp() {
        System.out.println("Erase something");
    }
}
