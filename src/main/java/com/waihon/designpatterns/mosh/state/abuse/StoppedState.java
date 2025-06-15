package com.waihon.designpatterns.mosh.state.abuse;

public class StoppedState implements StopwatchState {
    private ComplexStopwatch stopwatch;

    public StoppedState(ComplexStopwatch stopwatch) {
        this.stopwatch = stopwatch;
    }

    @Override
    public void click() {
        System.out.println("Running");
        stopwatch.setCurrentState(new RunningState(stopwatch));
    }
}
