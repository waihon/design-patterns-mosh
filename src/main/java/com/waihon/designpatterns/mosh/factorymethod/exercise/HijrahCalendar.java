package com.waihon.designpatterns.mosh.factorymethod.exercise;

import java.time.chrono.HijrahDate;

public class HijrahCalendar implements Calendar {
    @Override
    public void scheduleEventOnToday(Event event) {
        var today = formattedToday();

        System.out.printf("Adding event '%s' on %s", event.getName(), today);
    }

    @Override
    public String formattedToday() {
        return HijrahDate.now().toString();
    }
}
