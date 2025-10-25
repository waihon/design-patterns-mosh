package com.waihon.designpatterns.mosh.iterator.open;

public interface Aggregate<T> {
    void push(T item);
    T pop();
    int getSize();
    Iterator<T> createIterator();
}
