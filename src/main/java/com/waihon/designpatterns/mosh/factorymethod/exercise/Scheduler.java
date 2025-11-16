package com.waihon.designpatterns.mosh.factorymethod.exercise;

public class Scheduler {
    private Calendar calendar = createCalendar();

    public void schedule(Event event) {
        calendar.scheduleEventOnToday(event);
    }

    protected Calendar createCalendar() {
        return new GregorianCalendar();
    }
}
