package com.waihon.designpatterns.mosh.iterator.exercise;

public interface Iterator<T> {
    boolean hasNext();
    T current();
    void next();
}
