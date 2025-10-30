package com.waihon.designpatterns.mosh.observer.pull;

import java.util.ArrayList;
import java.util.List;

public class DataSource extends Subject {
    private int value;

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;

        notifyObservers();
    }
}
