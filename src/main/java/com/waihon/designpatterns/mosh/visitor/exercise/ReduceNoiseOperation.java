package com.waihon.designpatterns.mosh.visitor.exercise;

public class ReduceNoiseOperation implements Operation {
    @Override
    public void apply(FactSegment segment) {
        System.out.println("Reduce Noise: Fact Segment");
    }

    @Override
    public void apply(FormatSegment segment) {
        System.out.println("Reduce Noise: Format Segment");
    }
}
