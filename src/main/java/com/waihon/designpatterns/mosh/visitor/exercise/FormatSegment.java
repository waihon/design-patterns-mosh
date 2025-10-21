package com.waihon.designpatterns.mosh.visitor.exercise;

public class FormatSegment implements Segment {
    @Override
    public void execute(Operation operation) {
        operation.apply(this);
    }
}
