package com.waihon.designpatterns.mosh.observer.push;

import java.util.ArrayList;
import java.util.List;

public abstract class Subject<T> {
    private List<Observer<T>> observers = new ArrayList<>();

    public void addObserver(Observer<T> observer) {
        observers.add(observer);
    }

    public void removeObserver(Observer<T> observer) {
        observers.remove(observer);
    }

    protected void notifyObservers(T value) {
        for (var observer : observers) {
            observer.update(value);
        }
    }
}
