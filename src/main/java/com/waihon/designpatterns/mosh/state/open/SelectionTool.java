package com.waihon.designpatterns.mosh.state.open;

public class SelectionTool implements Tool {

    private Canvas canvas;

    public SelectionTool(Canvas canvas) {
        this.canvas = canvas;
    }

    @Override
    public void mouseDown() {
        System.out.println("Selection icon");
    }

    @Override
    public void mouseUp() {
        System.out.println("Draw dashed rectangle");
    }

}
