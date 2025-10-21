package com.waihon.designpatterns.mosh.visitor.exercise;

public class AddReverbOperation implements Operation {
    @Override
    public void apply(FactSegment segment) {
        System.out.println("Add Reverb: Fact Segment");
    }

    @Override
    public void apply(FormatSegment segment) {
        System.out.println("Add Reverb: Format Segment");
    }
}
