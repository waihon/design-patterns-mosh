package com.waihon.designpatterns.mosh.state.abuse;

public class ComplexStopwatch {
    private StopwatchState currentState;

    public void click() {
        currentState.click();
    }

    public StopwatchState getCurrentState() {
        return currentState;
    }

    public void setCurrentState(StopwatchState currentState) {
        this.currentState = currentState;
    }

}
