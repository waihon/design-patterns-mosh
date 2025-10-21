package com.waihon.designpatterns.mosh.visitor.exercise;

public class NormalizeOperation implements Operation {
    @Override
    public void apply(FactSegment segment) {
        System.out.println("Normalize: Fact Segment");
    }

    @Override
    public void apply(FormatSegment segment) {
        System.out.println("Normalize: Format Segment");
    }
}
