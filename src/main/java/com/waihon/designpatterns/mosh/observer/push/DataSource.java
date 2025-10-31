package com.waihon.designpatterns.mosh.observer.push;

import java.util.ArrayList;
import java.util.List;

public class DataSource extends Subject<Integer> {
    private Integer value;

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;

        notifyObservers(value);
    }
}
