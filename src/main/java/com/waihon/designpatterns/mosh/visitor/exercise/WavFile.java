package com.waihon.designpatterns.mosh.visitor.exercise;

import java.util.ArrayList;
import java.util.List;

public class WavFile {
    private List<Segment> segments = new ArrayList<>();

    public void add(Segment segment) {
        segments.add(segment);
    }

    public void execute(Operation operation) {
        for (var segment : segments) {
            segment.execute(operation);
        }
    }
}
