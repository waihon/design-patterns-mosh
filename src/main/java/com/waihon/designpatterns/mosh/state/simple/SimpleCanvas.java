package com.waihon.designpatterns.mosh.state.simple;

public class SimpleCanvas extends Canvas {

    public void mouseDown() {
        if (currentToolType == ToolType.SELECTION) {
            currentIconType = IconType.SELECTION;
        } else if (currentToolType == ToolType.BRUSH) {
            currentIconType = IconType.BRUSH;
        } else if (currentToolType == ToolType.ERASER) {
            currentIconType = IconType.ERASER;
        }
    }

    public void mouseUp() {
        if (currentToolType == ToolType.SELECTION) {
            currentActionType = ActionType.DRAW_DASHED_RECTANGLE;
        } else if (currentToolType == ToolType.BRUSH) {
            currentActionType = ActionType.DRAW_LINE;
        } else if (currentToolType == ToolType.ERASER) {
            currentActionType = ActionType.ERASE_SOMETHING;
        }
    }

}