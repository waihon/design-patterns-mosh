package com.waihon.designpatterns.mosh.state;

public class EraserTool implements Tool {

    private Canvas canvas;

    public EraserTool(Canvas canvas) {
        this.canvas = canvas;
    }

    @Override
    public void mouseDown() {
        canvas.setCurrentIconType(IconType.ERASER);
    }

    @Override
    public void mouseUp() {
        canvas.setCurrentActionType(ActionType.ERASE_SOMETHING);
    }
}
