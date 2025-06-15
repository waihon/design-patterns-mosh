package com.waihon.designpatterns.mosh.state;

public class SelectionTool implements Tool {

    private Canvas canvas;

    public SelectionTool(Canvas canvas) {
        this.canvas = canvas;
    }

    @Override
    public void mouseDown() {
        canvas.setCurrentIconType(IconType.SELECTION);
    }

    @Override
    public void mouseUp() {
        canvas.setCurrentActionType(ActionType.DRAW_DASHED_RECTANGLE);
    }

}
