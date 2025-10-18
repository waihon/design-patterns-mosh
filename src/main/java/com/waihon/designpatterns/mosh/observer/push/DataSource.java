package com.waihon.designpatterns.mosh.observer.push;

import java.util.ArrayList;
import java.util.List;

public class DataSource {
    private int value;
    private List<Observer> observers = new ArrayList<>();

    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;

        notifyObservers(value);
    }

    private void notifyObservers(int value) {
        for (var observer : observers) {
            observer.update(value);
        }
    }
}
