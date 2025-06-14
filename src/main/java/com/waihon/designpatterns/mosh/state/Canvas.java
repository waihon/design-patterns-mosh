package com.waihon.designpatterns.mosh.state;

public class Canvas {

    private ToolType currentTool;
    private IconType currentIcon;

    public void mouseDown() {
        if (currentTool == ToolType.SELECTION) {
            currentIcon = IconType.SELECTION;
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
}