package com.waihon.designpatterns.mosh.state.simple;

import com.waihon.designpatterns.mosh.state.open.Tool;

public class Canvas {

    protected ToolType currentToolType;
    protected IconType currentIconType;
    protected ActionType currentActionType;

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

    public ToolType getCurrentToolType() {
        return currentToolType;
    }

    public void setCurrentToolType(ToolType currentToolType) {
        this.currentToolType = currentToolType;
    }

    public IconType getCurrentIconType() {
        return currentIconType;
    }

    public void setCurrentIconType(IconType currentIconType) {
        this.currentIconType = currentIconType;
    }

    public ActionType getCurrentActionType() {
        return currentActionType;
    }

    public void setCurrentActionType(ActionType currentActionType) {
        this.currentActionType = currentActionType;
    }
}