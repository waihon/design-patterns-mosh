package com.waihon.designpatterns.mosh.mediator.exercise;

import java.util.ArrayList;
import java.util.List;

public abstract class UIControl {
    private List<Observer> observers = new ArrayList<>();

    public void attach(Observer observer) {
        observers.add(observer);
    }

    public void unattach(Observer observer) {
        observers.remove(observer);
    }

    public void notifyObservers() {
        for (var observer : observers) {
            observer.update();
        }
    }
}
