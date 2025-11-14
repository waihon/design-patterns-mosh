package com.waihon.designpatterns.mosh.prototype.exercise;

public class Clip implements Component {
    private int frameRate; // e.g. 24 fps, 30 fps

    public Clip(int frameRate) {
        this.frameRate = frameRate;
    }

    public int getFrameRate() {
        return frameRate;
    }

    @Override
    public Component clone() {
        return new Clip(this.frameRate);
    }
}
