package com.waihon.designpatterns.mosh.state;

public class Canvas {

    private ToolType currentTool;
    private IconType currentIcon;
    private ActionType currentAction;

    public void mouseDown() {
        if (currentTool == ToolType.SELECTION) {
            currentIcon = IconType.SELECTION;
        }
    }

    public void mouseUp() {
        if (currentTool == ToolType.SELECTION) {
            currentAction = ActionType.DRAW_DASHED_RECTANGLE;
        }
    }

    public ToolType getCurrentTool() {
        return currentTool;
    }

    public void setCurrentTool(ToolType currentTool) {
        this.currentTool = currentTool;
    }

    public IconType getCurrentIcon() {
        return currentIcon;
    }

    public void setCurrentIcon(IconType currentIcon) {
        this.currentIcon = currentIcon;
    }

    public ActionType getCurrentAction() {
        return currentAction;
    }

    public void setCurrentAction(ActionType currentAction) {
        this.currentAction = currentAction;
    }

}