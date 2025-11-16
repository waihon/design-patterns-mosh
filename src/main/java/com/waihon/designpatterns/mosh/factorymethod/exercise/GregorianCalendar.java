package com.waihon.designpatterns.mosh.factorymethod.exercise;

import java.time.LocalDate;

public class GregorianCalendar implements Calendar {
    @Override
    public void scheduleEventOnToday(Event event) {
        var today = formattedToday();

        System.out.printf("Adding event '%s' on %s", event.getName(), today);
    }

    @Override
    public String formattedToday() {
        return LocalDate.now().toString();
    }
}
