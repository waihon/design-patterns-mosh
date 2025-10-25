package com.waihon.designpatterns.mosh.iterator.exercise;

public interface Aggregate<T> {
    void push(T item);
    T pop();
    int getSize();
    Iterator<T> createIterator();
}
