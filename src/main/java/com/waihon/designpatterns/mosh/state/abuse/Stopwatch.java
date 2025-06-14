package com.waihon.designpatterns.mosh.state.abuse;

public class Stopwatch {

    private boolean isRunning = false;

    public void click() {
        if (isRunning) {
            System.out.println("Stopped");
        } else {
            System.out.println("Running");
        }
        isRunning = !isRunning;
    }

}
