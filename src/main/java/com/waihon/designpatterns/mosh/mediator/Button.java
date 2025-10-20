package com.waihon.designpatterns.mosh.mediator;

public class Button extends UIControl {
    private boolean enabled;

    public Button(DialogBox owner) {
        super(owner);
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;

        owner.changed(this);
    }
}
