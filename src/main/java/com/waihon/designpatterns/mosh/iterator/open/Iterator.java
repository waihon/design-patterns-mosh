package com.waihon.designpatterns.mosh.iterator.open;

public interface Iterator<T> {
    boolean hasNext();
    T current();
    void next();
}
