package com.waihon.designpatterns.mosh.state;

public class BrushTool implements Tool {

    private Canvas canvas;

    public BrushTool(Canvas canvas) {
        this.canvas = canvas;
    }

    @Override
    public void mouseDown() {
       canvas.setCurrentIconType(IconType.BRUSH);
    }

    @Override
    public void mouseUp() {
        canvas.setCurrentActionType(ActionType.DRAW_LINE);
    }

}
