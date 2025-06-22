package com.waihon.designpatterns.mosh.iterator;

public interface Iterator<T> {
    boolean hasNext();
    T current();
    void next();
}
