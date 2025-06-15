package com.waihon.designpatterns.mosh.state.abuse;

public class RunningState implements StopwatchState {
    private ComplexStopwatch stopwatch;

    public RunningState(ComplexStopwatch stopwatch) {
        this.stopwatch = stopwatch;
    }

    @Override
    public void click() {
        System.out.println("Stopped");
        stopwatch.setCurrentState(new RunningState(stopwatch));
    }
}
