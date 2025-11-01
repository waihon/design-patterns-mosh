package com.waihon.designpatterns.mosh.mediator.solution;

import java.util.ArrayList;
import java.util.List;

public abstract class Subject {
    protected List<EventHandler> eventHandlers = new ArrayList<>();

    public void addEventHandler(EventHandler handler) {
        eventHandlers.add(handler);
    }

    public void removeEventHandler(EventHandler handler) {
        eventHandlers.remove(handler);
    }

    public void notifyEventHandlers() {
        for (var handler : eventHandlers) {
            handler.handle();
        }
    }
}
