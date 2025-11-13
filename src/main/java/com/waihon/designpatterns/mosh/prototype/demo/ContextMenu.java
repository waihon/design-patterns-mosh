package com.waihon.designpatterns.mosh.prototype.demo;

public class ContextMenu {
    public Component duplicate(Component component) {
        Component newComponent = component.clone();

        // Add new component to our document

        return newComponent;
    }
}
