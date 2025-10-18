package com.waihon.designpatterns.mosh.observer.pull;

import java.util.ArrayList;
import java.util.List;

public class DataSource {
    private List<Observer> observers = new ArrayList<>();
    private int value;

    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    public void notifyObservers() {
        for (var observer : observers) {
            observer.update();
        }
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;

        notifyObservers();
    }
}
