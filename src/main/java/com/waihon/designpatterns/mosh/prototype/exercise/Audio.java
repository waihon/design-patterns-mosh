package com.waihon.designpatterns.mosh.prototype.exercise;

public class Audio implements Component {
    private int bitrate; // e.g. 128 kbps, 192 kbps

    public Audio(int bitrate) {
        this.bitrate = bitrate;
    }

    public int getBitrate() {
        return bitrate;
    }

    @Override
    public Component clone() {
        return new Audio(this.bitrate);
    }
}
