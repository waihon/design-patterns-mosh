package com.waihon.designpatterns.mosh.factorymethod.exercise;

public interface Calendar {
    void scheduleEventOnToday(Event event);
    String formattedToday();
}
