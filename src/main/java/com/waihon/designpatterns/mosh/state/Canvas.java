package com.waihon.designpatterns.mosh.state;

public abstract class Canvas {

    protected ToolType currentToolType;
    protected IconType currentIconType;
    protected ActionType currentActionType;

    public abstract void mouseDown();

    public abstract void mouseUp();

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