package com.waihon.designpatterns.mosh.factorymethod.exercise;

public class HijrahScheduler extends Scheduler {
    @Override
    protected Calendar createCalendar() {
        return new HijrahCalendar();
    }
}
