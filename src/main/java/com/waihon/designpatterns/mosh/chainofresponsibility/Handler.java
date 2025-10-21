package com.waihon.designpatterns.mosh.chainofresponsibility;

public abstract class Handler {
    private Handler next;

    public Handler(Handler next) {
        this.next = next;
    }

    public void handle(HttpRequest request) {
        if (doHandle(request)) {
            return;
        }

        if (next != null) {
            next.handle(request);
        }
    }

    // A return value of true indicates an early exit from the processing pipeline.
    public abstract boolean doHandle(HttpRequest request);
}
