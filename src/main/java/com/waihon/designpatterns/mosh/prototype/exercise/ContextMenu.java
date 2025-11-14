package com.waihon.designpatterns.mosh.prototype.exercise;

public class ContextMenu {
    private Timeline timeline;

    public ContextMenu(Timeline timeline) {
        this.timeline = timeline;
    }

    public void duplicate(Component component) {
        var newComponent = component.clone();

        timeline.add(newComponent);
    }
}
