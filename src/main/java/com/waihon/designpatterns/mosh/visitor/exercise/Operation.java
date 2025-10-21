package com.waihon.designpatterns.mosh.visitor.exercise;

public interface Operation {
    void apply(FactSegment segment);
    void apply(FormatSegment segment);
}
