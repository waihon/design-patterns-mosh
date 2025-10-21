package com.waihon.designpatterns.mosh.visitor.exercise;

public class FactSegment implements Segment {
    @Override
    public void execute(Operation operation) {
        operation.apply(this);
    }
}
