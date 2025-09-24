package com.waihon.designpatterns.mosh.state.exercise;

public class DirectionService {
    private Travel travel;

    public Object getEta() {
        return travel.getEta();
    }

    public Object getDirection() {
        return travel.getDirection();
    }

    public Travel getTravel() {
        return travel;
    }

    public void setTravel(Travel travel) {
        this.travel = travel;
    }
}
